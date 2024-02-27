package com.automated.trading.stock.StockManager.blockchain.service;

import com.automated.trading.stock.StockManager.blockchain.controller.dto.GenerateHashDto;
import com.automated.trading.stock.StockManager.blockchain.controller.dto.TransactionRequestDto;
import com.automated.trading.stock.StockManager.blockchain.domain.Block;
import com.automated.trading.stock.StockManager.blockchain.domain.Data;
import com.automated.trading.stock.StockManager.blockchain.domain.Transaction;
import com.automated.trading.stock.StockManager.blockchain.domain.Wallet;
import com.automated.trading.stock.StockManager.util.exception.KeyGenerationFailException;
import com.automated.trading.stock.StockManager.util.exception.TransactionCheckException;
import com.automated.trading.stock.StockManager.util.secrets.CrypticSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;

@Slf4j
@Service
@Transactional
public class BlockChainServiceImpl implements BlockChainService {

    private final CrypticSecurity crypticSecurity;

    public BlockChainServiceImpl(CrypticSecurity crypticSecurity) {
        this.crypticSecurity = crypticSecurity;
    }

    private LinkedList<Block> blockChain = new LinkedList<>();

    /**
     * 새로 생성되는 Block의 Hash 생성
     * Synchronized 키워드로 비동기 설정 --> Single Thread? ConcurrentHashmap?
     */
    @Override
    public synchronized String generateHash(GenerateHashDto generateHashDto) {
        try {
            String combinedData = generateHashDto.getPreviousHash() + generateHashDto.getData() + generateHashDto.getTimeStamp();

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(combinedData.getBytes());

            StringBuilder hashString = new StringBuilder();
            for (byte b : hash) {
                hashString.append(String.format("%02x", b));
            }

            return hashString.toString();
        } catch (NoSuchAlgorithmException e) {
            return e.toString();
        }
    }

    /**
     * 처음 추가하는 노드일 경우 이전 해시가 없다.
     * 처음 추가하는 노드일 경우 previous_hash를 ""인 공백으로 넣는다.

     * Hash, Data를 함께 생성
     */
    @Override
    public void createBlock(int member_id) {

        // 현재 시간
        LocalDateTime dateTime;
        dateTime = LocalDateTime.now();

        // previous hash
        String previous_hash;
        if (blockChain.isEmpty()) {
            previous_hash = "";
        } else {
            previous_hash = blockChain.getLast().getHash();
        }

        // data
        Data newData = new Data();
        String data = newData.transactionString();

        // hash
        String hash = generateHash(new GenerateHashDto(previous_hash, data, dateTime.toString()));

        newData.setHash(hash);
        blockChain.add(new Block(hash, previous_hash, member_id, newData));

        /* Block 생성 후 자동적으로 지갑 생성 */
        newData.setWallet(createWallet(member_id, createKeypair()));
    }

    /**
     * KeyPair (개인키, 공개키) 생성
     * 공개키와 개인키는 각각 암호화되어 반환되고, 지갑 생성 메서드에서 지갑에 저장된다
     */
    @Override
    public String[] createKeypair() {

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("prime192v1");

            keyPairGenerator.initialize(ecGenParameterSpec, secureRandom);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            String[] pairs = getStrings(keyPair);
            String priKey = crypticSecurity.encrypt(pairs[0]);
            String pubKeyX = crypticSecurity.encrypt(pairs[1]);
            String pubKeyY = crypticSecurity.encrypt(pairs[2]);

            String[] keys = new String[3];
            keys[0] = pubKeyX;
            keys[1] = pubKeyY;
            keys[2] = priKey;
            return keys;
        } catch (Exception e) {
            throw new KeyGenerationFailException();
        }

    }

    private static String[] getStrings(KeyPair keyPair) {
        PrivateKey key = keyPair.getPrivate();

        String parsing = key.toString();
        parsing = parsing.replace("EC Private Key", "");
        parsing = parsing.replaceAll(" ", "");
        parsing = parsing.replaceAll("X:", "");
        parsing = parsing.replaceAll("Y:", "");
        parsing = parsing.replaceAll(":", "");
        parsing = parsing.replaceAll("\\[", "");
        parsing = parsing.replaceAll("]", "");

        String[] parsed;
        parsed = parsing.split("\n");
        return parsed;
    }

    /**
     * [ 지갑 생성 ]
     */
    @Override
    public Wallet createWallet(int member_id, String[] keys) {
        return new Wallet(keys[1], keys[2], new HashMap<>());
    }

    /**
     * [ 사용자 입력 공개키 본인 인증 ]
     * 사용자의 member_id 를 이용하여 Block 을 찾고
     * Block 의 Wallet 에 가지고 있는 사용자의 공개키와 사용자가 입력한 공개키를 비교하여 (비교하는 과정에서 암호화, 복호화 필요)
     * 일치하면 로그에 "공개키 확인이 완료되었습니다."를,
     * 일치하지 않으면 에러를 날리게 구현
     */
    @Override
    public void checkAuthority(int member_id, String input) throws Exception {
        for (Block block : blockChain) {
            if (block.getMember_id() == member_id) {
                if (!crypticSecurity.decrypt(block.getData().getWallet().getPublicKey()).equals(input)) {
                    throw new TransactionCheckException();
                }
            }
        }
        log.info("공개키 확인이 완료되었습니다.");
    }

    /**
     * [ Transaction 실행 ]
     * - Transaction 객체 생성
     * - 생성한 객체를 senderKey와 receiverKey로 Block을 찾아 Block의 Data의 트랜젝션 기록에 저장
     */
    @Override
    public void executeTransaction(int member_id, String input, String senderKey, String receiverKey, TransactionRequestDto dto) {
        try {
            checkAuthority(member_id, input);
            Transaction transaction = Transaction.builder()
                    .sender_key(senderKey)
                    .receiver_key(receiverKey)
                    .name(dto.getName())
                    .count(dto.getCount())
                    .build();

            for (Block block : blockChain) {
                if (senderKey.equals(block.getData().getWallet().getPublicKey())) {
                    block.getData().addTransaction(transaction);
                }
                if (receiverKey.equals(block.getData().getWallet().getPublicKey())) {
                    block.getData().addTransaction(transaction);
                }
            }
        } catch (TransactionCheckException transactionCheckException) {
            throw transactionCheckException;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Transaction 발생할 때마다 실행
     */
    @Override
    public void updateHash() {

        for (Block block : blockChain) {
            String previous_hash = block.getPrevious_hash();
            String data = block.getData().toString();
            String time_stamp = block.getTime_stamp().toString();

            String hash = generateHash(new GenerateHashDto(previous_hash, data, time_stamp));
            block.setHash(hash);
        }

    }

    /**
     * [ Block 삭제 : LinkedList 중간 노드 삭제 ]
     * 필요하게 되었을 때 구현 예정
     */
    @Override
    public void deleteBlock(int block_id) {
    }

}

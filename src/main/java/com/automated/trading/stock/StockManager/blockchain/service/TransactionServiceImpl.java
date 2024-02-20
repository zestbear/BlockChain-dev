package com.automated.trading.stock.StockManager.blockchain.service;

import com.automated.trading.stock.StockManager.blockchain.controller.dto.TransactionRequestDto;
import com.automated.trading.stock.StockManager.blockchain.domain.Wallet;
import com.automated.trading.stock.StockManager.util.exception.KeyGenerationFailException;
import com.automated.trading.stock.StockManager.util.secrets.CrypticSecurity;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    /**
     * Wallet
     * - 개인키, 공개키 저장
     * - Transaction 생성
     * - Transaction 저장 (-> Data)
     */

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final CrypticSecurity crypticSecurity;

    public TransactionServiceImpl(CrypticSecurity crypticSecurity) {
        this.crypticSecurity = crypticSecurity;
    }

    /**
     * KeyPair (개인키, 공개키) 생성
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

    @Override
    public void createWallet(int member_id, String[] keys) {

        Wallet wallet = new Wallet(keys[0], keys[1], keys[2], new HashMap<>());

    }

    @Override
    public void executeTransaction(String senderKey, String receiverKey, TransactionRequestDto dto) {
//        Integer sending = dto.getCount() * (-1);
//        Wallet senderOldWallet =
//        Wallet receiverOldWallet =
//
//        Integer receiving = dto.getCount();
//        Wallet senderNewWallet =
//        Wallet receiverNewWallet =
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

        String[] parsed = new String[3];
        parsed = parsing.split("\n");
        return parsed;
    }


    /*
        Transaction (거래) 이 일어날 때 사용
        Cryptographic signature (서명) 을 할 때 사용자가 입력한 개인키가 맞는지 확인
     */
//    @Override
//    public Boolean checkKey(SearchKeyPairDto searchKeyPairDto, String privateKey) throws Exception {    // privateKey : 사용자 입력 Key
//        String pubKeyX = cryptionSecurity.decrypt(searchKeyPairDto.getPublicKeyX());
//        String pubKeyY = cryptionSecurity.decrypt(searchKeyPairDto.getPublicKeyY());
//        String priKey;
//
//        Optional<com.automated.trading.stock.StockManager.wallet.domain.KeyPair> byPublicKey = keyPairRepository.findByPublicKey(pubKeyX, pubKeyY);
//        if (byPublicKey.isPresent()) {
//            priKey = cryptionSecurity.decrypt(byPublicKey.get().getPrivateKey());
//            return priKey.equals(privateKey);
//        }
//        return false;
//    }

}

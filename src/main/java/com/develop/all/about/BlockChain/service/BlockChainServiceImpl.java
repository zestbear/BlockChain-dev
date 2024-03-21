package com.develop.all.about.BlockChain.service;

import com.develop.all.about.BlockChain.web.dto.GenerateHashDto;
import com.develop.all.about.BlockChain.domain.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.LinkedList;

@Service
@Transactional
public class BlockChainServiceImpl implements BlockChainService {

    /**
     * Block 정의 class
     */
    @Getter
    class Block {
        @Setter
        String hash; // 자신의 hash
        String previous_hash; // 이전 Block hash
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime time_stamp; // Block 생성 시간
        int member_id; // Block 사용자
        Data data;

        public Block(String hash, String previous_hash, int member_id, Data data) {
            this.hash = hash;
            this.previous_hash = previous_hash;
            this.time_stamp = LocalDateTime.now();
            this.member_id = member_id;
            this.data = data;
        }

    }

    private LinkedList<Block> blockChain = new LinkedList<>();

    /**
     * 새로 생성되는 Block의 Hash 생성
     */
    @Override
    public String generateHash(GenerateHashDto generateHashDto) {
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
     * Synchronized 키워드로 비동기 설정 --> Single Thread? ConcurrentHashmap?

     * Hash, Data를 함께 생성
     */
    @Override
    public synchronized void createBlock(int member_id) {

        // 현재 시간
        LocalDateTime dateTime;
        dateTime = LocalDateTime.now();

        // previous hash
        String previous_hash;
        if (blockChain.isEmpty()) {
            previous_hash = "";
        } else {
            previous_hash = blockChain.getLast().hash;
        }

        // data
        Data newData = new Data();
        String data = newData.transactionString();

        // hash
        String hash = generateHash(new GenerateHashDto(previous_hash, data, dateTime.toString()));

        newData.setHash(hash);
        blockChain.add(new Block(hash, previous_hash, member_id, newData));
    }

    /**
     * Scheduled로 관리할 Hash 업데이트 메서드
     */
    @Override
    public void updateHash() {

        for (Block block : blockChain) {
            String previous_hash = block.previous_hash;
            String data = block.data.toString();
            String time_stamp = block.time_stamp.toString();

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

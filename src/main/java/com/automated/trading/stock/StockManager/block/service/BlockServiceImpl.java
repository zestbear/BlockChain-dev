package com.automated.trading.stock.StockManager.block.service;

import com.automated.trading.stock.StockManager.block.domain.Block;
import com.automated.trading.stock.StockManager.block.domain.BlockRepository;
import com.automated.trading.stock.StockManager.block.dto.GenerateHashDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;

    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    /*
        새로 생성되는 Block의 Hash 생성
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


    /*
        이전 Block의 Hash인 previousHash 값 가져오기

        Dto를 이용하여 previousHash, timeStamp, data 객체의 String 타입을 generateHash 함수로 넘겨줌
        generateHash 함수는 Dto를 이용하여 새로운 Hash를 생성하여 반환
        generateBlock은 새로 생성된 Hash 값을 previousHash, data, timeStamp과 함께 새로운 Block을 생성하여 Repository에 저장


        [2024-01-16] count() 함수에서 오류 날 가능성이 있음 --> 테스트 필요
    */
    @Override
    public void generateBlock(String hash) throws JsonProcessingException {
        String previousHash = null;
        String timeStamp = LocalDate.now().toString();
        String data = null;
        ObjectMapper objectMapper = new ObjectMapper();

        long count = blockRepository.count();
        if (count > 1L) {
            Optional<Block> byId = blockRepository.findById(count - 1L);
            Block preBlock;
            if (byId.isPresent()) {
                preBlock = byId.get();

                previousHash = preBlock.getPreviousHash();
                data = objectMapper.writeValueAsString(preBlock.getData());
            }
        }

        GenerateHashDto dto = GenerateHashDto.builder()
                .previousHash(previousHash)
                .data(data)
                .timeStamp(timeStamp)
                .build();

        Block newBlock = Block.builder()
                .hash(generateHash(dto))
                .previousHash(previousHash)
                .data(data)
                .timeStamp(timeStamp)
                .build();

        blockRepository.save(newBlock);
    }

}

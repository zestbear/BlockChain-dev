package com.automated.trading.stock.StockManager.stock.block;

import com.automated.trading.stock.StockManager.stock.block.dto.BlockSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.block.dto.BlockUpdateRequestDto;
import com.automated.trading.stock.StockManager.stock.block.dto.GenerateHashDto;
import com.automated.trading.stock.StockManager.stock.block.dto.ReturnBlockResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

    private final BlockMapper blockMapper;

    public BlockServiceImpl(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    /*
        새로 생성되는 Block의 Hash 생성
        Synchronized 키워드로 비동기 설정 --> Single Thread? ConcurrentHashmap?
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

    /*
        추가하는 Block이 첫 Block이면 그냥 추가
        하지만 첫 BLock이 아니라면 다음 순서를 따라야 한다.
        1. 마지막 Block(is_last가 true인 Block)의 is_last를 false로 변경
        2. 새로운 Block 추가
     */
    @Override
    public void createBlock(BlockSaveRequestDto dto) {

        // 현재 시간
        LocalDateTime localDateTime;
        localDateTime = LocalDateTime.now();
        dto.setTime_stamp(localDateTime.toString());

        // previous hash
        String previous_hash = blockMapper.getLastHash();
        dto.setPrevious_hash(previous_hash);

        // data
        String data = "data"; // 추후 변경 예정

        // hash
        String hash = generateHash(new GenerateHashDto(previous_hash, data, localDateTime.toString()));
        dto.setHash(hash);

        blockMapper.createBlock(dto);
    }

    @Override
    public void updateBlock(BlockUpdateRequestDto dto) {
        blockMapper.updateBlock(dto);
    }

    /*
        [ Block 삭제 : LinkedList 중간 노드 삭제 ]
        - 노드 삭제 전에 첫 노드인지 검사 (block의 위치를 처음 중간 끝으로 나눠 검사 해야할 듯)
        - 첫 노드가 아니라면 삭제할 노드의 previous_hash를 다음 노드의 previous_hash로 변경 --> 여기서 findByHash 메서드가 필요
        - 삭제 완료
     */
    @Override
    public void deleteBlock(int block_id) {
        blockMapper.deleteBlock(block_id);
    }

    @Override
    public synchronized ReturnBlockResponseDto findByHash(String hash) {
        return blockMapper.findByHash(hash);
    }

    @Override
    public synchronized ReturnBlockResponseDto findByPreviousHash(String previous_hash) {
        return blockMapper.findByPreviousHash(previous_hash);
    }


    /*
        이전 Block의 Hash인 previousHash 값 가져오기

        Dto를 이용하여 previousHash, timeStamp, data 객체의 String 타입을 generateHash 함수로 넘겨줌
        generateHash 함수는 Dto를 이용하여 새로운 Hash를 생성하여 반환
        generateBlock은 새로 생성된 Hash 값을 previousHash, data, timeStamp과 함께 새로운 Block을 생성하여 Repository에 저장


        [2024-01-16] count() 함수에서 오류 날 가능성이 있음 --> 테스트 필요
    */
//    @Override
//    public void generateBlock(String hash) throws JsonProcessingException {
//        String previousHash = null;
//        String timeStamp = LocalDate.now().toString();
//        String data = null;
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        long count = blockRepository.count();
//        if (count > 1L) {
//            Optional<Block> byId = blockRepository.findById(count - 1L);
//            Block preBlock;
//            if (byId.isPresent()) {
//                preBlock = byId.get();
//
//                previousHash = preBlock.getPreviousHash();
//                data = objectMapper.writeValueAsString(preBlock.getData());
//            }
//        }
//
//        GenerateHashDto dto = GenerateHashDto.builder()
//                .previousHash(previousHash)
//                .data(data)
//                .timeStamp(timeStamp)
//                .build();
//
//        Block newBlock = Block.builder()
//                .hash(generateHash(dto))
//                .previousHash(previousHash)
//                .data(data)
//                .timeStamp(timeStamp)
//                .build();
//
//        blockRepository.save(newBlock);
//    }

}

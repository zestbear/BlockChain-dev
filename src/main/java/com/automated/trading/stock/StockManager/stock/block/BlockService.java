package com.automated.trading.stock.StockManager.stock.block;

import com.automated.trading.stock.StockManager.stock.block.dto.BlockSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.block.dto.BlockUpdateRequestDto;
import com.automated.trading.stock.StockManager.stock.block.dto.GenerateHashDto;
import com.automated.trading.stock.StockManager.stock.block.dto.ReturnBlockResponseDto;

public interface BlockService {

    public String generateHash(GenerateHashDto generateHashDto);

//    public void generateBlock(String hash) throws JsonProcessingException;

    public void createBlock(BlockSaveRequestDto dto);

    public void updateBlock(BlockUpdateRequestDto dto);

    public void deleteBlock(int block_id);

    public ReturnBlockResponseDto findByHash(String hash);

    public ReturnBlockResponseDto findByPreviousHash(String previous_hash);

}

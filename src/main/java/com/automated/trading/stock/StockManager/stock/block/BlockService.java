package com.automated.trading.stock.StockManager.stock.block;

import com.automated.trading.stock.StockManager.stock.block.dto.GenerateHashDto;
import com.automated.trading.stock.StockManager.stock.block.dto.ReturnBlockResponseDto;

public interface BlockService {

    String generateHash(GenerateHashDto generateHashDto);

    void createBlock(int member_id);

    void deleteBlock(int block_id);

}

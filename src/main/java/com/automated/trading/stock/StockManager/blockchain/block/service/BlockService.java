package com.automated.trading.stock.StockManager.blockchain.block.service;

import com.automated.trading.stock.StockManager.blockchain.block.controller.dto.GenerateHashDto;

public interface BlockService {

    String generateHash(GenerateHashDto generateHashDto);

    void createBlock(int member_id);

    void deleteBlock(int block_id);

}

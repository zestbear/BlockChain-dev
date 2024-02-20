package com.automated.trading.stock.StockManager.blockchain.service;

import com.automated.trading.stock.StockManager.blockchain.controller.dto.GenerateHashDto;

public interface BlockChainService {

    String generateHash(GenerateHashDto generateHashDto);

    void createBlock(int member_id);

    void deleteBlock(int block_id);

}

package com.automated.trading.stock.StockManager.block.service;

import com.automated.trading.stock.StockManager.block.dto.GenerateHashDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface BlockService {

    public String generateHash(GenerateHashDto generateHashDto);

    public void generateBlock(String hash) throws JsonProcessingException;

}

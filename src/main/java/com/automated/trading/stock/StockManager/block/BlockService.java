package com.automated.trading.stock.StockManager.block;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface BlockService {

    public String generateHash(GenerateHashDto generateHashDto);

//    public void generateBlock(String hash) throws JsonProcessingException;

}

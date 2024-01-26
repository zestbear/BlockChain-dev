package com.automated.trading.stock.StockManager.stock.block;

import com.automated.trading.stock.StockManager.stock.block.dto.GenerateHashDto;

public interface BlockService {

    public String generateHash(GenerateHashDto generateHashDto);

//    public void generateBlock(String hash) throws JsonProcessingException;

}

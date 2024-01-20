package com.automated.trading.stock.StockManager.block;

import com.automated.trading.stock.StockManager.block.domain.Block;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GenerateHashDto {

    private String previousHash;
    private String data;
    private String timeStamp;

}

package com.automated.trading.stock.StockManager.stock.block.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GenerateHashDto {

    private String previousHash;
    private String data;
    private String timeStamp;

}

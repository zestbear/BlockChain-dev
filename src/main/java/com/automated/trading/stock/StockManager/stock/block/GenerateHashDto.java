package com.automated.trading.stock.StockManager.stock.block;

import com.automated.trading.stock.StockManager.stock.block.domain.Block;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GenerateHashDto {

    private String previousHash;
    private String data;
    private String timeStamp;

    @Builder
    public GenerateHashDto(String previousHash, String data, String timeStamp) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = timeStamp;
    }

    public GenerateHashDto toDto(Block entity) {
        return GenerateHashDto.builder()
                .previousHash(entity.getHash())
                .data(entity.getData().toString())
                .timeStamp(entity.getTimeStamp().toString())
                .build();
    }

}

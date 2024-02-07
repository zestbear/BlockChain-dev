package com.automated.trading.stock.StockManager.stock.block.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlockSaveRequestDto {

    private String hash;
    private String previous_hash;
    private String time_stamp;
    private int member_id;

}

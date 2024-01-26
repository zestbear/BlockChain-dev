package com.automated.trading.stock.StockManager.stock.block.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockDto {

    private int block_id;
    private String hash;
    private String previous_hash;
    private String time_stamp;
    private int member_id;

}

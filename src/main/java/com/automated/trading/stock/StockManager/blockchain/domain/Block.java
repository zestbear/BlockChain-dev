package com.automated.trading.stock.StockManager.blockchain.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class Block {

    @Setter
    private String hash; // 자신의 hash
    private final String previous_hash; // 이전 Block hash
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime time_stamp; // Block 생성 시간
    private final int member_id; // Block 사용자
    private final Data data;

    public Block(String hash, String previous_hash, int member_id, Data data) {
        this.hash = hash;
        this.previous_hash = previous_hash;
        this.time_stamp = LocalDateTime.now();
        this.member_id = member_id;
        this.data = data;
    }

}

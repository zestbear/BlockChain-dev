package com.automated.trading.stock.StockManager.blockchain.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
public class Transaction {

    String sender_key;
    String receiver_key;
    String name;
    int count;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime tran_at;
//        String transaction_input;
//        String transaction_output;
//        String signature;

    @Builder
    public Transaction(String sender_key, String receiver_key, String name, int count) {
        this.sender_key = sender_key;
        this.receiver_key = receiver_key;
        this.name = name;
        this.count = count;
        this.tran_at = LocalDateTime.now();
    }

}

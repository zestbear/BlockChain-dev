package com.develop.all.about.BlockChain.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Transaction {

    private String sender_key;
    private String receiver_key;
    private String name;
    private int count;
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

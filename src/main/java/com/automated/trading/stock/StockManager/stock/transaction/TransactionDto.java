package com.automated.trading.stock.StockManager.stock.transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

    private int transaction_id; // PK
    private String sender_key;
    private String receiver_key;
    private int count;
    private String transaction_input;
    private String transaction_output;
    private String signature;
    private String tran_dt;
    private int data_fk; // FK

}

package com.automated.trading.stock.StockManager.blockchain.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Data {

    @Setter
    String hash;
    @Setter
    Wallet wallet;
    List<Transaction> transaction_log;

    public Data() {
        this.transaction_log = new ArrayList<>();
    }

    public String transactionString() {
        return transaction_log.toString();
    }

    public void addTransaction(Transaction transaction) {
        this.transaction_log.add(transaction);
    }

}

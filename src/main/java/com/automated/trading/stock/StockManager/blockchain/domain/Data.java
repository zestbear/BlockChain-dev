package com.automated.trading.stock.StockManager.blockchain.domain;

import java.util.ArrayList;
import java.util.List;

public class Data {

    int member_id;
    List<Transaction> transaction_log;

    public Data(int member_id) {
        this.member_id = member_id;
        transaction_log = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transaction_log.add(transaction);
    }

}

package com.automated.trading.stock.StockManager.block.domain;

import com.automated.trading.stock.StockManager.transaction.Transaction;
import com.automated.trading.stock.StockManager.wallet.domain.Wallet;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Wallet wallet;

    @OneToMany
    private ArrayList<Transaction> transactions;

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

}

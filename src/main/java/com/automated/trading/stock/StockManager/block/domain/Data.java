package com.automated.trading.stock.StockManager.block.domain;

import com.automated.trading.stock.StockManager.wallet.domain.Wallet;
import jakarta.persistence.*;

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

}

package com.automated.trading.stock.StockManager.block.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long id;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private String previousHash;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_id")
    private Data data;

    @Column
    private String timeStamp;


}

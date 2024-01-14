package com.automated.trading.stock.StockManager.block.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

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
    @CreatedDate
    private LocalDateTime timeStamp;

}

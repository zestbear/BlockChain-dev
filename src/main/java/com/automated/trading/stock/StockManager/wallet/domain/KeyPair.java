package com.automated.trading.stock.StockManager.wallet.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class KeyPair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "keypair_id")
    private Long id;

    @Column
    private String publicKeyX;

    @Column
    private String publicKeyY;

    @Column
    private String privateKey;

    @Builder
    public KeyPair(String publicKeyX, String publicKeyY, String privateKey) {
        this.publicKeyX = publicKeyX;
        this.publicKeyY = publicKeyY;
        this.privateKey = privateKey;
    }
}

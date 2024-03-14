package com.develop.all.about.BlockChain.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Wallet {

    private final String publicKey;
    private final String privateKey;

    private Map<String, Integer> stock;

    public Wallet(String publicKey, String privateKey, Map<String, Integer> stock) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.stock = new HashMap<>(stock);
    }

    /**
     * 공개키와 개인키들이 '불변'이기 때문에 Wallet을 업데이트할 때 Wallet 안의 값을 바꾸는 것이 아닌 새로운 Wallet을 반환하여 대체
     * EX) oldWallet = newWallet;
     */
    public Wallet updateStock(String name, Integer count) {
        Map<String, Integer> newStock = new HashMap<>(stock);
        newStock.merge(name, count, Integer::sum);
        return new Wallet(publicKey, privateKey, newStock);
    }

}

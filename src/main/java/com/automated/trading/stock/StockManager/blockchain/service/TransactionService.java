package com.automated.trading.stock.StockManager.blockchain.service;

public interface TransactionService {

    String[] createKeypair();

    void executeTransaction(String senderKey, String receiverKey);

//    public Boolean checkKey(SearchKeyPairDto searchKeyPairDto, String privateKey) throws Exception;

}

package com.automated.trading.stock.StockManager.blockchain.service;

import com.automated.trading.stock.StockManager.blockchain.controller.dto.TransactionRequestDto;

public interface TransactionService {

    String[] createKeypair();

    void createWallet(int member_id, String[] keys);

    void executeTransaction(String senderKey, String receiverKey, TransactionRequestDto dto);

//    public Boolean checkKey(SearchKeyPairDto searchKeyPairDto, String privateKey) throws Exception;

}

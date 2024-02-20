package com.automated.trading.stock.StockManager.blockchain.transaction;

import java.util.List;

public interface TransactionService {

    void transactionOccurred(TransactionDto dto);

    List<TransactionDto> getAllTransactions();

    TransactionDto findBySenderKey(String sender_key);

    TransactionDto findByReceiverKey(String receiver_key);

    TransactionDto findBySignature(String signature);

//    List<TransactionDto> findByDateTime(TransactionDto dto);

}

package com.automated.trading.stock.StockManager.stock.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void transactionOccurred(TransactionDto dto) {
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return null;
    }

    @Override
    public TransactionDto findBySenderKey(String sender_key) {
        return null;
    }

    @Override
    public TransactionDto findByReceiverKey(String receiver_key) {
        return null;
    }

    @Override
    public TransactionDto findBySignature(String signature) {
        return null;
    }

//    @Override
//    public List<TransactionDto> findByDateTime(TransactionDto dto) {
//        return transactionMapper.findByDateTime(dto);
//    }

}

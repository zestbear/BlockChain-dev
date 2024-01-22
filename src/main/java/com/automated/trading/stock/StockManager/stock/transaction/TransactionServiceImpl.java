package com.automated.trading.stock.StockManager.stock.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    @Override
    public void transactionOccurred(TransactionDto dto) {
        transactionMapper.transactionOccurred(dto);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionMapper.getAllTransactions();
    }

    @Override
    public TransactionDto findBySenderKey(String sender_key) {
        return transactionMapper.findBySenderKey(sender_key);
    }

    @Override
    public TransactionDto findByReceiverKey(String receiver_key) {
        return transactionMapper.findByReceiverKey(receiver_key);
    }

    @Override
    public TransactionDto findBySignature(String signature) {
        return transactionMapper.findBySignature(signature);
    }

    @Override
    public List<TransactionDto> findByDateTime(String start_dt, String end_dt) {
        return transactionMapper.findByDateTime(start_dt, end_dt);
    }

}

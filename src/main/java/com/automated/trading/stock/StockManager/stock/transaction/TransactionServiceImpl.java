package com.automated.trading.stock.StockManager.stock.transaction;

import com.automated.trading.stock.StockManager.util.mapper.TransactionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

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

//    @Override
//    public List<TransactionDto> findByDateTime(TransactionDto dto) {
//        return transactionMapper.findByDateTime(dto);
//    }

}

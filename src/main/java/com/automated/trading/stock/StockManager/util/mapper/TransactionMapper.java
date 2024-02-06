//package com.automated.trading.stock.StockManager.util.mapper;
//
//import com.automated.trading.stock.StockManager.stock.transaction.TransactionDto;
//import org.apache.ibatis.annotations.Mapper;
//
//import java.util.List;
//
//@Mapper
//public interface TransactionMapper {
//
//    void transactionOccurred(TransactionDto transactionDto);
//
//    List<TransactionDto> getAllTransactions();
//
//    TransactionDto findBySenderKey(String sender_key);
//
//    TransactionDto findByReceiverKey(String receiver_key);
//
//    TransactionDto findBySignature(String signature);
//
////    List<TransactionDto> findByDateTime(String start_dt, String end_dt); // String start_dt, String end_dt
//
//}

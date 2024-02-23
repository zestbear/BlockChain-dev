package com.automated.trading.stock.StockManager.blockchain.service;

import com.automated.trading.stock.StockManager.blockchain.controller.dto.GenerateHashDto;
import com.automated.trading.stock.StockManager.blockchain.controller.dto.TransactionRequestDto;
import com.automated.trading.stock.StockManager.blockchain.domain.Wallet;

public interface BlockChainService {

    /** Block 관련 기능 */
    String generateHash(GenerateHashDto generateHashDto);
    void createBlock(int member_id);
    void updateHash();
    void deleteBlock(int block_id);

    /** Wallet 및 Transaction 관련 기능 */
    String[] createKeypair();
    Wallet createWallet(int member_id, String[] keys);
    void checkAuthority(int member_id, String input) throws Exception;
    void executeTransaction(String senderKey, String receiverKey, TransactionRequestDto dto);

}

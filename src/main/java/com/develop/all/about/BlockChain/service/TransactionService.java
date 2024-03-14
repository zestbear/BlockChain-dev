package com.develop.all.about.BlockChain.service;

import com.develop.all.about.BlockChain.web.dto.TransactionRequestDto;

public interface TransactionService {

    String[] createKeypair();

    void createWallet(int member_id, String[] keys);

    void executeTransaction(String senderKey, String receiverKey, TransactionRequestDto dto);

//    public Boolean checkKey(SearchKeyPairDto searchKeyPairDto, String privateKey) throws Exception;

}

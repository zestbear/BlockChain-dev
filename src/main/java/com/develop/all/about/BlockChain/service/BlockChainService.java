package com.develop.all.about.BlockChain.service;

import com.develop.all.about.BlockChain.web.dto.GenerateHashDto;

public interface BlockChainService {

    String generateHash(GenerateHashDto generateHashDto);

    void createBlock(int member_id);

    void updateHash();

    void deleteBlock(int block_id);

}

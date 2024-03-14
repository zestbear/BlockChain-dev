package com.develop.all.about.BlockChain.web.controller;

import com.develop.all.about.BlockChain.service.BlockChainService;
import com.develop.all.about.BlockChain.api.ApiResponse;
import com.develop.all.about.BlockChain.api.ApiResponseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BlockChainController {

    private final BlockChainService blockChainService;

    public BlockChainController(BlockChainService blockChainService) {
        this.blockChainService = blockChainService;
    }

    /**
     * Block 생성
     * member_id 사용하여 사용자와 연결
     * Linked List 자료구조 사용
     */
    @PostMapping("/block/{member_id}")
    public ApiResponse<String> createBlock(@PathVariable("member_id") int member_id) {
        try {
            blockChainService.createBlock(member_id);
        } catch (Exception e) {
            log.error(ApiResponseType.BAD_REQUEST.getMessage());
            return new ApiResponse<>(ApiResponseType.BAD_REQUEST);
        }
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

}

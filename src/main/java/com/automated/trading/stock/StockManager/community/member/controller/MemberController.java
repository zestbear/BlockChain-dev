package com.automated.trading.stock.StockManager.community.member.controller;

import com.automated.trading.stock.StockManager.community.member.service.MemberService;
import com.automated.trading.stock.StockManager.util.api.ApiResponse;
import com.automated.trading.stock.StockManager.util.api.ApiResponseType;
import com.automated.trading.stock.StockManager.util.exception.MemberDuplicatedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 앱 내 최초 로그인 및 회원가입
     */
    @PostMapping("/join")
    public ApiResponse<String> join(@RequestBody MemberJoinRequestDto dto) {

        try {
            memberService.join(dto);
        } catch (MemberDuplicatedException memberDuplicatedException) {
            return new ApiResponse<>(ApiResponseType.DuplicatedEmail_ERROR);
        }

        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }
}
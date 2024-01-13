package com.automated.trading.stock.StockManager.member.controller.dto;

import com.automated.trading.stock.StockManager.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinRequestDto {
    private String loginID;
    private String loginPW;
    private String nickName;
    private String email;

    @Builder
    public JoinRequestDto(String loginID, String loginPW, String nickName, String email) {
        this.loginID = loginID;
        this.loginPW = loginPW;
        this.nickName = nickName;
        this.email = email;
    }

    public Member toEntity() {
        return Member.builder()
                .loginID(loginID)
                .loginPW(loginPW)
                .nickName(nickName)
                .email(email)
                .build();
    }

}

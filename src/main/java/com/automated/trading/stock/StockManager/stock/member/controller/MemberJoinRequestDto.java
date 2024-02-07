package com.automated.trading.stock.StockManager.stock.member.controller;

import com.automated.trading.stock.StockManager.stock.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberJoinRequestDto {

    private String name;
    private String email;
    private String picture;

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .picture(this.picture)
                .build();
    }

}

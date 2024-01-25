package com.automated.trading.stock.StockManager.stock.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private int member_id;
    private String name;
    private String email;
    private String picture;
    private MemberRole role;

}

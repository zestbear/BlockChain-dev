package com.automated.trading.stock.StockManager.community.qna.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReturnQnaResponseDto {

    private String title;
    private String content;
    private String wrt_dt;
    private String mod_dt;
    private Boolean secret;

    @Builder
    public ReturnQnaResponseDto(String title, String content, String wrt_dt, String mod_dt, Boolean secret) {
        this.title = title;
        this.content = content;
        this.wrt_dt = wrt_dt;
        this.mod_dt = mod_dt;
        this.secret = secret;
    }

}

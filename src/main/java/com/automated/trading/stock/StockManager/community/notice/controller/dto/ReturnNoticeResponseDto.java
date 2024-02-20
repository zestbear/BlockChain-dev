package com.automated.trading.stock.StockManager.community.notice.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReturnNoticeResponseDto {

    /**
     * 공지사항 List 반환을 위한 Dto
     */
    private String title;
    private String content;
    private String wrt_dt;
    private String mod_dt;
    private Boolean imprtnc;

    @Builder
    public ReturnNoticeResponseDto(String title, String content, String wrt_dt, String mod_dt, Boolean imprtnc) {
        this.title = title;
        this.content = content;
        this.wrt_dt = wrt_dt;
        this.mod_dt = mod_dt;
        this.imprtnc = imprtnc;
    }

}

package com.automated.trading.stock.StockManager.stock.notice.controller.dto;

import lombok.Getter;

@Getter
public class NoticeSaveRequestDto {

    /**
     * 공지사항 저장을 위한 Dto
     * @Setter 삭제
     */
    private String title;
    private String content;
    private Boolean imprtnc;

}

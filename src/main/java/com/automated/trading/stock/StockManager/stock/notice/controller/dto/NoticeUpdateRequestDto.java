package com.automated.trading.stock.StockManager.stock.notice.controller.dto;

import lombok.Getter;

@Getter
public class NoticeUpdateRequestDto {

    /**
     * 공지사항 수정을 위한 Dto
     */
    private String title;
    private String content;

}

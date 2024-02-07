package com.automated.trading.stock.StockManager.stock.qna.controller.dto;

import lombok.Getter;

@Getter
public class QnaSaveRequestDto {

    private String title;
    private String content;
    private Boolean secret;

}

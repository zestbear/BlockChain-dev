package com.automated.trading.stock.StockManager.stock.qna.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaSaveRequestDto {

    private int member_id;
    private String title;
    private String content;
    private Boolean secret;

}

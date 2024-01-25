package com.automated.trading.stock.StockManager.stock.post.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoticeSaveRequestDto {

    /*
        공지사항 저장을 위한 Dto
     */
    private int member_id;
    private String title;
    private String content;
    private Boolean imprtnc;

}

package com.automated.trading.stock.StockManager.stock.notice.controller.dto;

import lombok.Getter;

@Getter
public class NoticeDeleteRequestDto {

    /**
     * 공지사항 삭제를 위한 Dto
     */
    private int member_id;
    private int post_fk;

}

package com.automated.trading.stock.StockManager.stock.post.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeUpdateRequestDto {

    private int member_id;
    private String title;
    private String content;
    private int post_fk;

}

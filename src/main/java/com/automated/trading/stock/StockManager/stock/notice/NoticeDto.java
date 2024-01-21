package com.automated.trading.stock.StockManager.stock.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDto {

    private int notice_id;
    private String title;
    private String content;
    private String post_type;
    private String wrt_dt;
    private Boolean imprtnc;

}

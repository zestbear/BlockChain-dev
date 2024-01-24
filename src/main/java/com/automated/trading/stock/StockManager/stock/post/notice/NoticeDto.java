package com.automated.trading.stock.StockManager.stock.post.notice;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoticeDto {

    private int post_fk;
    private int member_id;
    private String title;
    private String content;
    private String post_type;
    private String wrt_dt;
    private String mod_dt;
    private Boolean imprtnc;

}

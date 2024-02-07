package com.automated.trading.stock.StockManager.stock.qna.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReturnQnaResponseDto {

    private int member_id;
    private String title;
    private String content;
    private String wrt_dt;
    private String mod_dt;
    private Boolean secret;
    private PostType post_type;
    private int post_fk;

}

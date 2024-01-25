package com.automated.trading.stock.StockManager.stock.post.qna.dto;

import com.automated.trading.stock.StockManager.stock.post.PostType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QnaListResponseDto {

    private int member_id;
    private String title;
    private String content;
    private String wrt_dt;
    private String mod_dt;
    private Boolean secret;
    private PostType post_type;
    private int post_fk;

}

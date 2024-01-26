package com.automated.trading.stock.StockManager.stock.post.notice.dto;

import com.automated.trading.stock.StockManager.stock.post.PostType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnNoticeResponseDto {

    /*
        공지사항 List 반환을 위한 Dto
     */
    private int member_id;
    private String title;
    private String content;
    private String wrt_dt;
    private String mod_dt;
    private Boolean imprtnc;
    private PostType post_type;
    private int post_fk;

}

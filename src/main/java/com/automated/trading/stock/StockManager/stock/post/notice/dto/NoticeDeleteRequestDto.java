package com.automated.trading.stock.StockManager.stock.post.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDeleteRequestDto {

    /*
        공지사항 삭제를 위한 Dto
     */
    private int member_id;
    private int post_fk;

}

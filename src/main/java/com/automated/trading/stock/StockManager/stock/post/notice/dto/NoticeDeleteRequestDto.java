package com.automated.trading.stock.StockManager.stock.post.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDeleteRequestDto {

    private int member_id;
    private int post_fk;

}

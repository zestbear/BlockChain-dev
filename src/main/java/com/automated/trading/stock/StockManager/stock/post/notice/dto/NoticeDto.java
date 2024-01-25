package com.automated.trading.stock.StockManager.stock.post.notice.dto;

import com.automated.trading.stock.StockManager.stock.post.PostType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoticeDto {

    /*
        공지사항 Dto

        Dto를 공지사항의 저장, 수정, 삭제, 반환의 기능에 따라 모두 분리
        사용하거나 반환하고자 하는 정보 외의 정보들을 감출 수 있음
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

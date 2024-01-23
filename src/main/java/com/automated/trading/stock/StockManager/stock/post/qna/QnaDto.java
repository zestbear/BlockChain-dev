package com.automated.trading.stock.StockManager.stock.post.qna;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QnaDto {

    private int qna_id;
    private String title;
    private String content;
    private String wrt_dt;
    private String mod_dt;

}

package com.automated.trading.stock.StockManager.community.comment.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReturnCommentResponseDto {

    private String content;
    private String writer;
    private int recommends;

    @Builder
    public ReturnCommentResponseDto(String content, String writer, int recommends) {
        this.content = content;
        this.writer = writer;
        this.recommends = recommends;
    }

}

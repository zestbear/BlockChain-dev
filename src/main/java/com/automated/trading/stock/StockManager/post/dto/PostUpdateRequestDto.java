package com.automated.trading.stock.StockManager.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {

    private String title;
    private String content;
    private String postAttachmentType;

    @Builder
    public PostUpdateRequestDto(String title, String content, String postAttachmentType) {
        this.title = title;
        this.content = content;
        this.postAttachmentType = postAttachmentType;
    }

}

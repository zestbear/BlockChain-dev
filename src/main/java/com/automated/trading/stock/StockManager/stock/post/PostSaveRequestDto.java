package com.automated.trading.stock.StockManager.stock.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private String postType;
    private String postAttachmentType;

    @Builder
    public PostSaveRequestDto(String title, String content, String postType, String postAttachmentType) {
        this.title = title;
        this.content = content;
        this.postType = postType;
        this.postAttachmentType = postAttachmentType;
    }

}

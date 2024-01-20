package com.automated.trading.stock.StockManager.stock.post;

public interface PostService {

    public void postSave(PostSaveRequestDto requestDto);

    public void postUpdate(PostUpdateRequestDto requestDto);

    public void postDelete(Long postId);

}

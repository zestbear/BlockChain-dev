package com.automated.trading.stock.StockManager.post.service;

import com.automated.trading.stock.StockManager.post.dto.PostSaveRequestDto;
import com.automated.trading.stock.StockManager.post.dto.PostUpdateRequestDto;

public interface PostService {

    public void postSave(PostSaveRequestDto requestDto);

    public void postUpdate(PostUpdateRequestDto requestDto);

    public void postDelete(Long postId);

}

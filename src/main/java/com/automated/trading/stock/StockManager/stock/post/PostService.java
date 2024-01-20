package com.automated.trading.stock.StockManager.stock.post;

import com.automated.trading.stock.StockManager.stock.post.dto.PostSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.post.dto.PostUpdateRequestDto;

public interface PostService {

    public void postSave(PostSaveRequestDto requestDto);

    public void postUpdate(PostUpdateRequestDto requestDto);

    public void postDelete(Long postId);

}

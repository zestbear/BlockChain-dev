package com.automated.trading.stock.StockManager.stock.post.qna;

import com.automated.trading.stock.StockManager.stock.post.notice.NoticeDto;

public interface QnaService {

    public void postSave(QnaDto dto);

    public void postUpdate(NoticeDto dto);

    public void postDelete(Long postId);

}

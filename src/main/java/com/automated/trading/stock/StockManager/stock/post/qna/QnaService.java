package com.automated.trading.stock.StockManager.stock.post.qna;

import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.post.qna.dto.QnaDto;

public interface QnaService {

    public void postSave(QnaDto dto);

    public void postUpdate(NoticeSaveRequestDto dto);

    public void postDelete(Long postId);

}

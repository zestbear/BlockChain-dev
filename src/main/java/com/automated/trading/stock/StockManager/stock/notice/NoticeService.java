package com.automated.trading.stock.StockManager.stock.notice;

public interface NoticeService {

    public void postSave(NoticeDto dto);

    public void postUpdate(NoticeDto dto);

    public void postDelete(Long postId);

}

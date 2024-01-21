package com.automated.trading.stock.StockManager.stock.notice;

import java.util.List;

public interface NoticeService {

    public void saveNotice(NoticeDto dto);

    public void updateNotice(NoticeDto dto);

    public void deleteNotice(NoticeDto dto);

    public List<NoticeDto> findAllNotices();

    public NoticeDto findById(int notice_id);

}

package com.automated.trading.stock.StockManager.stock.post.notice;

import java.util.List;

public interface NoticeService {

    void saveNotice(NoticeDto dto);

    void updateNotice(NoticeDto dto);

    void deleteNotice(NoticeDto dto);

    List<NoticeDto> findAllNotices();

    NoticeDto findById(int notice_id);

}

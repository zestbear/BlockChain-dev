package com.automated.trading.stock.StockManager.stock.post.notice;

import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeDeleteRequestDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeListResponseDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeUpdateRequestDto;

import java.util.List;

public interface NoticeService {

    void saveNotice(NoticeSaveRequestDto dto);

    void updateNotice(NoticeUpdateRequestDto dto);

    void deleteNotice(NoticeDeleteRequestDto dto);

    List<NoticeListResponseDto> findAllNotices();

    NoticeListResponseDto findById(int notice_id);

}

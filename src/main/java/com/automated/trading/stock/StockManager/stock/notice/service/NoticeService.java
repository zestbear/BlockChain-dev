package com.automated.trading.stock.StockManager.stock.notice.service;

import com.automated.trading.stock.StockManager.stock.notice.controller.dto.NoticeUpdateRequestDto;
import com.automated.trading.stock.StockManager.stock.notice.controller.dto.ReturnNoticeResponseDto;
import com.automated.trading.stock.StockManager.stock.notice.controller.dto.NoticeSaveRequestDto;

import java.util.List;

public interface NoticeService {

    void saveNotice(Long writer, NoticeSaveRequestDto dto);

    void updateNotice(Long writer, Long post_fk, NoticeUpdateRequestDto dto);

    void deleteNotice(Long writer, Long post_fk);

    List<ReturnNoticeResponseDto> findAllNotices(int size, int page);

}

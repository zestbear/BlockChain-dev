package com.automated.trading.stock.StockManager.community.notice.service;

import com.automated.trading.stock.StockManager.community.notice.controller.dto.NoticeSaveRequestDto;
import com.automated.trading.stock.StockManager.community.notice.controller.dto.NoticeUpdateRequestDto;
import com.automated.trading.stock.StockManager.community.notice.controller.dto.ReturnNoticeResponseDto;

import java.util.List;

public interface NoticeService {

    void saveNotice(Long writer, NoticeSaveRequestDto dto);

    void updateNotice(Long writer, Long post_fk, NoticeUpdateRequestDto dto);

    void deleteNotice(Long writer, Long post_fk);

    List<ReturnNoticeResponseDto> findAllNotices(int size, int page);

}

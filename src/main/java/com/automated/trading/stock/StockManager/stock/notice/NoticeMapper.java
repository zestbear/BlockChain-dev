package com.automated.trading.stock.StockManager.stock.notice;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    void saveNotice(NoticeDto dto);

    void updateNotice(NoticeDto dto);

    void deleteNotice(NoticeDto dto);

    List<NoticeDto> findAllNotices();

    NoticeDto findById(int notice_id);

}

package com.automated.trading.stock.StockManager.stock.notice;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDto> findAllNotices();

    void saveNotice(NoticeDto dto);

    void updateNotice(NoticeDto dto);

    void deleteNotice(int notice_id);

    NoticeDto findById(int notice_id);

}

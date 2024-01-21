package com.automated.trading.stock.StockManager.stock.notice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Override
    public void saveNotice(NoticeDto dto) {
    }

    @Override
    public void updateNotice(NoticeDto dto) {
    }

    @Override
    public void deleteNotice(NoticeDto dto) {
    }

    @Override
    public List<NoticeDto> findAllNotices() {
        return null;
    }

    @Override
    public NoticeDto findById(int notice_id) {
        return null;
    }

}

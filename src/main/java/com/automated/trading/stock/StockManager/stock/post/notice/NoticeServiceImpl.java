package com.automated.trading.stock.StockManager.stock.post.notice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public void saveNotice(NoticeDto dto) {
        noticeMapper.saveNotice(dto);
    }

    @Override
    public void updateNotice(NoticeDto dto) {
        noticeMapper.updateNotice(dto);
    }

    @Override
    public void deleteNotice(NoticeDto dto) {
        noticeMapper.deleteNotice(dto);
    }

    @Override
    public List<NoticeDto> findAllNotices() {
        return noticeMapper.findAllNotices();
    }

    @Override
    public NoticeDto findById(int notice_id) {
        return noticeMapper.findById(notice_id);
    }

}

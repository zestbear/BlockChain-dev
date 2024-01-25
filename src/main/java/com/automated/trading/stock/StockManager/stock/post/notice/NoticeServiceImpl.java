package com.automated.trading.stock.StockManager.stock.post.notice;

import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeDeleteRequestDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeListResponseDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeUpdateRequestDto;
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
    public void saveNotice(NoticeSaveRequestDto dto) {
        noticeMapper.saveNotice(dto);
    }

    @Override
    public void updateNotice(NoticeUpdateRequestDto dto) {
        noticeMapper.updateNotice(dto);
    }

    @Override
    public void deleteNotice(NoticeDeleteRequestDto dto) {
        noticeMapper.deleteNotice(dto);
    }

    @Override
    public List<NoticeListResponseDto> findAllNotices() {
        return noticeMapper.findAllNotices();
    }

    @Override
    public NoticeListResponseDto findById(int notice_id) {
        return noticeMapper.findById(notice_id);
    }

}

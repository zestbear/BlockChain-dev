package com.automated.trading.stock.StockManager.stock.post.qna;

import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.post.qna.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QnaServiceImpl implements QnaService {

    private final QnaMapper qnaMapper;

    public QnaServiceImpl(QnaMapper qnaMapper) {
        this.qnaMapper = qnaMapper;
    }

    @Override
    public void saveQna(QnaSaveRequestDto dto) {
        qnaMapper.saveQna(dto);
    }

    @Override
    public void updateQna(QnaUpdateRequestDto dto) {
        qnaMapper.updateQna(dto);
    }

    @Override
    public void deleteQna(QnaDeleteRequestDto dto) {
        qnaMapper.deleteQna(dto);
    }

    @Override
    public List<QnaListResponseDto> findAllQnas() {
        return qnaMapper.findAllQnas();
    }

    @Override
    public QnaListResponseDto findById(int qna_id) {
        return qnaMapper.findById(qna_id);
    }

}

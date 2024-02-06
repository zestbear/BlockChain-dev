package com.automated.trading.stock.StockManager.stock.post.qna;

import com.automated.trading.stock.StockManager.stock.post.qna.dto.*;
import com.automated.trading.stock.StockManager.util.mapper.QnaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QnaServiceImpl implements QnaService {

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
    public List<ReturnQnaResponseDto> findAllQnas() {
        return qnaMapper.findAllQnas();
    }

    @Override
    public ReturnQnaResponseDto findById(int qna_id) {
        return qnaMapper.findById(qna_id);
    }

}

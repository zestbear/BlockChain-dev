package com.automated.trading.stock.StockManager.stock.qna;

import com.automated.trading.stock.StockManager.stock.qna.dto.QnaDeleteRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.dto.QnaSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.dto.QnaUpdateRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.dto.ReturnQnaResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QnaServiceImpl implements QnaService {

    @Override
    public void saveQna(QnaSaveRequestDto dto) {
    }

    @Override
    public void updateQna(QnaUpdateRequestDto dto) {
    }

    @Override
    public void deleteQna(QnaDeleteRequestDto dto) {
    }

    @Override
    public List<ReturnQnaResponseDto> findAllQnas() {
        return null;
    }

    @Override
    public ReturnQnaResponseDto findById(int qna_id) {
        return null;
    }

}

package com.automated.trading.stock.StockManager.stock.qna;

import com.automated.trading.stock.StockManager.stock.qna.dto.QnaDeleteRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.dto.ReturnQnaResponseDto;
import com.automated.trading.stock.StockManager.stock.qna.dto.QnaSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.dto.QnaUpdateRequestDto;

import java.util.List;

public interface QnaService {

    void saveQna(QnaSaveRequestDto dto);

    void updateQna(QnaUpdateRequestDto dto);

    void deleteQna(QnaDeleteRequestDto dto);

    List<ReturnQnaResponseDto> findAllQnas();

    ReturnQnaResponseDto findById(int qna_id);

}

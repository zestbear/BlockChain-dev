package com.automated.trading.stock.StockManager.stock.qna.service;

import com.automated.trading.stock.StockManager.stock.qna.controller.dto.ReturnQnaResponseDto;
import com.automated.trading.stock.StockManager.stock.qna.controller.dto.QnaSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.controller.dto.QnaUpdateRequestDto;

import java.util.List;

public interface QnaService {

    void saveQna(Long writer, QnaSaveRequestDto dto);

    void updateQna(Long writer, Long post_id, QnaUpdateRequestDto dto);

    List<ReturnQnaResponseDto> findAllQnas(int size, int page);

}

package com.automated.trading.stock.StockManager.stock.post.qna;

import com.automated.trading.stock.StockManager.stock.post.qna.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {

    void saveQna(QnaSaveRequestDto dto);

    void updateQna(QnaUpdateRequestDto dto);

    void deleteQna(QnaDeleteRequestDto dto);

    List<QnaListResponseDto> findAllQnas();

    QnaListResponseDto findById(int qna_id);

}

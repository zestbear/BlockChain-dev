package com.automated.trading.stock.StockManager.stock.post.qna;

import com.automated.trading.stock.StockManager.stock.post.qna.dto.QnaDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {

    void saveQna(QnaDto dto);

    void updateQna(QnaDto dto);

    void deleteQna(QnaDto dto);

    List<QnaDto> findAllQnas();

    QnaDto findById(int qna_id);

}

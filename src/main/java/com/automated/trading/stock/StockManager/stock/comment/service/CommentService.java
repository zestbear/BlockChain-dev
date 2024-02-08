package com.automated.trading.stock.StockManager.stock.comment.service;

import com.automated.trading.stock.StockManager.stock.comment.controller.dto.CommentSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.comment.controller.dto.ReturnCommentResponseDto;

import java.util.List;

public interface CommentService {

    void saveComment(Long qna_id, Long member_id, CommentSaveRequestDto dto);

    List<ReturnCommentResponseDto> findAllComments(Long qna_id);

    int addRecommends(Long comment_id);

}

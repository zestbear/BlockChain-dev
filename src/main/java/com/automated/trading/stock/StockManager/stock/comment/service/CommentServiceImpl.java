package com.automated.trading.stock.StockManager.stock.comment.service;

import com.automated.trading.stock.StockManager.stock.comment.controller.dto.CommentSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.comment.controller.dto.ReturnCommentResponseDto;
import com.automated.trading.stock.StockManager.stock.comment.domain.Comment;
import com.automated.trading.stock.StockManager.stock.comment.domain.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public void saveComment(Long qna_id, CommentSaveRequestDto dto) {
    }

    @Override
    public List<ReturnCommentResponseDto> findAllComments(Long qna_id) {
        List<Comment> allComment = commentRepository.findAllComment(qna_id);
        List<ReturnCommentResponseDto> returnComment = new ArrayList<>();
        for (Comment comment : allComment) {
            returnComment.add(comment.toEntity());
        }

        return returnComment;
    }

    @Override
    @Transactional
    public void addRecommends(Long comment_id) {
    }
}

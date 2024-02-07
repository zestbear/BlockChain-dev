package com.automated.trading.stock.StockManager.stock.comment.controller;

import com.automated.trading.stock.StockManager.stock.comment.controller.dto.CommentSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.comment.controller.dto.ReturnCommentResponseDto;
import com.automated.trading.stock.StockManager.stock.comment.service.CommentService;
import com.automated.trading.stock.StockManager.util.api.ApiResponse;
import com.automated.trading.stock.StockManager.util.api.ApiResponseType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/qna/{qna_id}")
    public ApiResponse<String> saveComment(@PathVariable("qna_id") Long qna_id,
                                           @RequestBody CommentSaveRequestDto dto) {
        commentService.saveComment(qna_id, dto);
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

    @GetMapping("/comment/{qna_id}")
    public ApiResponse<List<ReturnCommentResponseDto>> findAllComment(@PathVariable("qna_id") Long qna_id) {
        return new ApiResponse<>(commentService.findAllComments(qna_id));
    }

    @PutMapping("/qna/{comment_id}")
    public ApiResponse<String> addRecommends(@PathVariable("comment_id") Long comment_id) {
        commentService.addRecommends(comment_id);
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

}

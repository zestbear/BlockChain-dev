package com.automated.trading.stock.StockManager.stock.comment.controller;

import com.automated.trading.stock.StockManager.stock.comment.controller.dto.CommentSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.comment.controller.dto.ReturnCommentResponseDto;
import com.automated.trading.stock.StockManager.stock.comment.service.CommentService;
import com.automated.trading.stock.StockManager.util.api.ApiResponse;
import com.automated.trading.stock.StockManager.util.api.ApiResponseType;
import com.automated.trading.stock.StockManager.util.exception.CommentNotExistException;
import com.automated.trading.stock.StockManager.util.exception.MemberNotExistException;
import com.automated.trading.stock.StockManager.util.exception.PostNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 채팅 저장
     * 실패 case: qna_id 의 Q&A가 존재하지 않을 때
     * 실패 case: member_id 의 사용자가 존재하지 않을 때
     * @param qna_id
     * @param member_id
     * @param dto
     * @return
     */
    @PostMapping("/qna/{qna_id}/{member_id}")
    public ApiResponse<String> saveComment(@PathVariable("qna_id") Long qna_id,
                                           @PathVariable("member_id") Long member_id,
                                           @RequestBody CommentSaveRequestDto dto) {
        try {
            commentService.saveComment(qna_id, member_id, dto);
        } catch (MemberNotExistException memberNotExistException) {
            log.error(ApiResponseType.MemberNotExist_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.MemberNotExist_ERROR);
        } catch (PostNotExistException postNotExistException) {
            log.error(ApiResponseType.PostNotExist_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.PostNotExist_ERROR);
        }
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

    /**
     * 채팅 모두 불러오기
     * 실패 case: qna_id 의 Q&A가 존재하지 않을 때
     * @param qna_id
     * @return
     */
    @GetMapping("/comment/{qna_id}")
    public ApiResponse<List<ReturnCommentResponseDto>> findAllComment(@PathVariable("qna_id") Long qna_id) {
        try {
            return new ApiResponse<>(commentService.findAllComments(qna_id));
        } catch (PostNotExistException postNotExistException) {
            return new ApiResponse<>(ApiResponseType.PostNotExist_ERROR);
        }
    }

    /**
     * 채팅 좋아요 +1
     * 실패 case: comment_id 의 채팅이 존재하지 않을 때
     * 실패 case: 오류로 인해 좋아요가 적용되지 않았을 때
     * @param comment_id
     * @return
     */
    @PutMapping("/qna/{comment_id}")
    public ApiResponse<String> addRecommends(@PathVariable("comment_id") Long comment_id) {

        try {
            int executed = commentService.addRecommends(comment_id);
            if (executed == 0) {
                log.error(ApiResponseType.BAD_REQUEST.getMessage());
                return new ApiResponse<>(ApiResponseType.BAD_REQUEST);
            }
        } catch (CommentNotExistException commentNotExistException) {
            log.error(ApiResponseType.CommentNotExist_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.CommentNotExist_ERROR);
        }
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

}

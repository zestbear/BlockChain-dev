package com.automated.trading.stock.StockManager.community.qna.controller;

import com.automated.trading.stock.StockManager.community.qna.controller.dto.QnaUpdateRequestDto;
import com.automated.trading.stock.StockManager.community.qna.controller.dto.ReturnQnaResponseDto;
import com.automated.trading.stock.StockManager.community.qna.service.QnaService;
import com.automated.trading.stock.StockManager.community.qna.controller.dto.QnaSaveRequestDto;
import com.automated.trading.stock.StockManager.util.api.ApiResponse;
import com.automated.trading.stock.StockManager.util.api.ApiResponseType;
import com.automated.trading.stock.StockManager.util.exception.MemberNotExistException;
import com.automated.trading.stock.StockManager.util.exception.NullTextFieldException;
import com.automated.trading.stock.StockManager.util.exception.PostNotExistException;
import com.automated.trading.stock.StockManager.util.exception.PostWriterNotMatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class QnaController {

    /**
     * Q&A: 저장, 수정, 조회만 가능
     * 모두가 정보를 공유하기 위해 삭제 기능은 없음
     * 그렇기 때문에 수정 기능에 공백을 넣거나 아무것도 입력하지 않은 상태로의 수정은 허락되지 않음
     */

    private final QnaService qnaService;

    public QnaController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    /**
     * Q&A 저장
     * 실패 case: 작성하려는 사용자가 존재하지 않을 때
     * 실패 case: 저장하고자 하는 정보가 null 이거나 공백일 때
     */
    @PostMapping("/qna/save/{member_id}")
    public ApiResponse<String> saveQna(@PathVariable("member_id") Long writer,
                                       @RequestBody QnaSaveRequestDto dto) {
        try {
            qnaService.saveQna(writer, dto);
        } catch (NullTextFieldException nullTextFieldException) {
            log.error(ApiResponseType.NullTextField_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.NullTextField_ERROR);
        } catch (MemberNotExistException memberNotExistException) {
            log.error(ApiResponseType.MemberNotExist_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.MemberNotExist_ERROR);
        }
        log.info("Q&A가 성공적으로 저장되었습니다.");
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

    /**
     * Q&A 수정
     * 실패 case: 해당 게시물이 존재하지 않을 때
     * 실패 case: 수정하려는 게시물의 작성자가 수정하려는 사용자가 아닐 때 (작성자만 수정할 수 있다.)
     * 실패 case: 수정하고자 하는 정보가 null 이거나 공백일 때
     */
    @PutMapping("/qna/update/{member_id}/{post_id}")
    public ApiResponse<String> updateQna(@PathVariable("member_id") Long writer,
                                         @PathVariable("post_id") Long post_id,
                                         @RequestBody QnaUpdateRequestDto dto) {
        try {
            qnaService.updateQna(writer, post_id, dto);
        } catch (NullTextFieldException nullTextFieldException) {
            log.error(ApiResponseType.NullTextField_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.NullTextField_ERROR);
        } catch (PostNotExistException postNotExistException) {
            log.error(ApiResponseType.PostNotExist_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.PostNotExist_ERROR);
        } catch (PostWriterNotMatchException postWriterNotMatchException) {
            log.error(ApiResponseType.PostWriter_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.PostWriter_ERROR);
        }
        log.info("공지사항이 성공적으로 수정되었습니다.");
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

    /**
     * Q&A 모두 반환
     * - 페이징 완료
     */
    @GetMapping("/qna")
    public ApiResponse<List<ReturnQnaResponseDto>> findAllQnas(@RequestParam("size") int size,
                                                               @RequestParam("page") int page) {
        return new ApiResponse<>(qnaService.findAllQnas(size, page));
    }

}

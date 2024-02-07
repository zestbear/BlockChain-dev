package com.automated.trading.stock.StockManager.stock.notice.controller;

import com.automated.trading.stock.StockManager.stock.notice.controller.dto.NoticeUpdateRequestDto;
import com.automated.trading.stock.StockManager.stock.notice.controller.dto.ReturnNoticeResponseDto;
import com.automated.trading.stock.StockManager.stock.notice.service.NoticeService;
import com.automated.trading.stock.StockManager.stock.notice.controller.dto.NoticeSaveRequestDto;
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
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /**
     * 공지사항 저장
     * 실패 case: 작성하려는 사용자가 존재하지 않을 때
     * 실패 case: 저장하고자 하는 정보가 null 이거나 공백일 때
     */
    @PostMapping("/notice/save/{member_id}")
    public ApiResponse<String> saveNotice(@PathVariable("member_id") Long writer,
                                          @RequestBody NoticeSaveRequestDto dto) {
        try {
            noticeService.saveNotice(writer, dto);
        } catch (NullTextFieldException nullTextFieldException) {
            log.error(ApiResponseType.NullTextField_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.NullTextField_ERROR);
        } catch (MemberNotExistException memberNotExistException) {
            log.error(ApiResponseType.MemberNotExist_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.MemberNotExist_ERROR);
        }
        log.info("공지사항이 성공적으로 저장되었습니다.");
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

    /**
     * 공지사항 수정
     * 실패 case: 해당 게시물이 존재하지 않을 때
     * 실패 case: 수정하려는 게시물의 작성자가 수정하려는 사용자가 아닐 때 (작성자만 수정할 수 있다.)
     * 실패 case: 수정하고자 하는 정보가 null 이거나 공백일 때
     */
    @PutMapping("/notice/update/{member_id}/{post_id}")
    public ApiResponse<String> updateNotice(@PathVariable("member_id") Long writer,
                                            @PathVariable("post_id") Long post_id,
                                            @RequestBody NoticeUpdateRequestDto dto) {
        try {
            noticeService.updateNotice(writer, post_id, dto);
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
     * 공지사항 삭제
     * 실패 case: 해당 게시물이 존재하지 않을 때
     * 실패 case: 삭제하려는 게시물의 작성자가 삭제하려는 사용자가 아닐 때 (작성자만 삭제할 수 있다.)
     */
    @DeleteMapping("/notice/delete/{member_id}/{post_id}")
    public ApiResponse<String> deleteNotice(@PathVariable("member_id") Long writer,
                                            @PathVariable("post_id") Long post_id) {
        try {
            noticeService.deleteNotice(writer, post_id);
        } catch (PostNotExistException postNotExistException) {
            log.error(ApiResponseType.PostNotExist_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.PostNotExist_ERROR);
        } catch (PostWriterNotMatchException postWriterNotMatchException) {
            log.error(ApiResponseType.PostWriter_ERROR.getMessage());
            return new ApiResponse<>(ApiResponseType.PostWriter_ERROR);
        }
        log.info("공지사항이 성공적으로 삭제되었습니다.");
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

    /**
     * 공지사항 모두 반환
     * - 페이징 완료
     */
    @GetMapping("/notice")
    public ApiResponse<List<ReturnNoticeResponseDto>> findAllNotices(@RequestParam("size") int size,
                                                                     @RequestParam("page") int page) {
        return new ApiResponse<>(noticeService.findAllNotices(size, page));
    }

}

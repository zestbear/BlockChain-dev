package com.automated.trading.stock.StockManager.stock.post.notice;

import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeDeleteRequestDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.ReturnNoticeResponseDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.post.notice.dto.NoticeUpdateRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /*
        공지사항 저장 Controller

        성공: Notice saved successfully
     */
    @PostMapping("/notice/save/{member_id}")
    public ResponseEntity<String> saveNotice(@PathVariable("member_id") int member_id,
                                             @RequestBody NoticeSaveRequestDto dto) {
        dto.setMember_id(member_id);

        try {
            noticeService.saveNotice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save notice: " + e.getMessage());
        }
        log.info("Notice saved successfully");
        return ResponseEntity.ok("Notice saved successfully");
    }

    /*
        공지사항 수정 Controller

        성공: Notice updated successfully
     */
    @PutMapping("/notice/update/{member_id}/{post_fk}")
    public ResponseEntity<String> updateNotice(@PathVariable("member_id") int member_id,
                             @PathVariable("post_fk") int post_fk,
                             @RequestBody NoticeUpdateRequestDto dto) {
        dto.setMember_id(member_id);
        dto.setPost_fk(post_fk);

        try {
            noticeService.updateNotice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update notice: " + e.getMessage());
        }
        log.info("Notice updated successfully");
        return ResponseEntity.ok("Notice updated successfully");
    }

    /*
        공지사항 삭제 Controller

        성공: Notice deleted successfully
     */
    @DeleteMapping("/notice/delete/{member_id}/{post_fk}")
    public ResponseEntity<String> deleteNotice(@PathVariable("member_id") int member_id,
                             @PathVariable("post_fk") int post_fk) {
        NoticeDeleteRequestDto dto = new NoticeDeleteRequestDto();
        dto.setMember_id(member_id);
        dto.setPost_fk(post_fk);

        try {
            noticeService.deleteNotice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete notice: " + e.getMessage());
        }
        log.info("Notice deleted successfully");
        return ResponseEntity.ok("Notice deleted successfully");
    }

    /*
        공지사항 모두 반환 Controller
     */
    @GetMapping("/notice")
    public List<ReturnNoticeResponseDto> findAllNotices() {
        return noticeService.findAllNotices();
    }

    /*
        공지사항 선택 반환 Controller
     */
    @GetMapping("/notice/{notice_id}")
    public ReturnNoticeResponseDto findById(@PathVariable("notice_id") int notice_id) {
        return noticeService.findById(notice_id);
    }

}

package com.automated.trading.stock.StockManager.stock.post.notice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("/notice/save/{member_id}")
    public ResponseEntity<String> saveNotice(@PathVariable("member_id") int member_id,
                                             @RequestBody NoticeDto dto) {
        dto.setMember_id(member_id);

        try {
            noticeService.saveNotice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save notice: " + e.getMessage());
        }
        return ResponseEntity.ok("Notice saved successfully");
    }

    @PutMapping("/notice/update/{member_id}/{notice_id}")
    public ResponseEntity<String> updateNotice(@PathVariable("member_id") int member_id,
                             @PathVariable("notice_id") int notice_id,
                             @RequestBody NoticeDto dto) {
        dto.setMember_id(member_id);
        dto.setNotice_id(notice_id);

        try {
            noticeService.updateNotice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update notice: " + e.getMessage());
        }
        return ResponseEntity.ok("Notice updated successfully");
    }

    @DeleteMapping("/notice/delete/{member_id}/{notice_id}")
    public ResponseEntity<String> deleteNotice(@PathVariable("member_id") int member_id,
                             @PathVariable("notice_id") int notice_id) {
        NoticeDto dto = new NoticeDto();
        dto.setMember_id(member_id);
        dto.setNotice_id(notice_id);

        try {
            noticeService.deleteNotice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete notice: " + e.getMessage());
        }
        return ResponseEntity.ok("Notice deleted successfully");
    }

    @GetMapping("/notice/getAll")
    public List<NoticeDto> findAllNotices() {
        return noticeService.findAllNotices();
    }

    @GetMapping("/notice/getNotice/{notice_id}")
    public NoticeDto findById(@PathVariable("notice_id") int notice_id) {
        return noticeService.findById(notice_id);
    }

}

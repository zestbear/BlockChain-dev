package com.automated.trading.stock.StockManager.stock.notice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("/notice/save/{member_id}")
    public void saveNotice(@PathVariable("member_id") int member_id,
                           @RequestBody NoticeDto dto) {
        dto.setMember_id(member_id);
        noticeService.saveNotice(dto);
    }

    @PutMapping("/notice/update/{member_id}/{notice_id}")
    public void updateNotice(@PathVariable("member_id") int member_id,
                             @PathVariable("notice_id") int notice_id,
                             @RequestBody NoticeDto dto) {
        dto.setMember_id(member_id);
        dto.setNotice_id(notice_id);
        noticeService.updateNotice(dto);
    }

    @DeleteMapping("/notice/delete/{member_id}/{notice_id}")
    public void deleteNotice(@PathVariable("member_id") int member_id,
                             @PathVariable("notice_id") int notice_id) {
        NoticeDto dto = new NoticeDto();
        dto.setMember_id(member_id);
        dto.setNotice_id(notice_id);
        noticeService.deleteNotice(dto);
    }

    @PostMapping("/notice/getAll")
    public List<NoticeDto> findAllNotices() {
        return noticeService.findAllNotices();
    }

    @PostMapping("/notice/getNotice/{notice_id}")
    public NoticeDto findById(@PathVariable("notice_id") int notice_id) {
        return noticeService.findById(notice_id);
    }

}

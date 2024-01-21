package com.automated.trading.stock.StockManager.stock.notice;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

}

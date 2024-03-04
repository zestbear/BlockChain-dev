package com.automated.trading.stock.StockManager.community.contact.controller;

import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactHoldRequestDto;
import com.automated.trading.stock.StockManager.community.contact.service.ContactService;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ReturnContactResponseDto;
import com.automated.trading.stock.StockManager.util.api.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact/send")
    public ApiResponse<String> sendContact(@RequestBody ContactSendRequestDto dto) {
        return null;
    }

    @PutMapping("/contact/respond")
    public ApiResponse<String> respondContact(@RequestBody ContactHoldRequestDto dto) {
        return null;
    }

    /**
     * TODO 날짜별 검색으로 수정 ** parameter, function **
     */
    @GetMapping("/contact/{contact_id}")
    public ApiResponse<ReturnContactResponseDto> findByDate(@PathVariable("contact_id") int contact_id) {
        return null;
    }

    /**
     * Contact는 Spring Security에서 Security 없이 접근할 수 있다.
     */
    @GetMapping("/contact")
    public ApiResponse<List<ReturnContactResponseDto>> findAllContacts() {
        return null;
    }

}

package com.automated.trading.stock.StockManager.stock.contact;

import com.automated.trading.stock.StockManager.stock.contact.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.stock.contact.dto.ContactSetStateRequestDto;
import com.automated.trading.stock.StockManager.stock.contact.dto.ReturnContactResponseDto;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact/send")
    public RequestEntity<String> sendContact(@RequestBody ContactSendRequestDto dto) {
        return null;
    }

    @PutMapping("/contact/respond")
    public RequestEntity<String> respondContact(@RequestBody ContactSetStateRequestDto dto) {
        return null;
    }

    @GetMapping("/contact/{contact_id}")
    public ReturnContactResponseDto findById(@PathVariable("contact_id") int contact_id) {
        return contactService.findById(contact_id);
    }

    /*
        Contact는 Spring Security에서 Security 없이 접근할 수 있다.
     */
    @GetMapping("/contact")
    public List<ReturnContactResponseDto> findAllContacts() {
        return contactService.findAllContacts();
    }

}

package com.automated.trading.stock.StockManager.stock.contact;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact/send")
    public RequestEntity<String> sendContact() {
        return null;
    }

    /*
        Contact는 Spring Security에서 Security 없이 접근할 수 있다.
     */
    @GetMapping("/contact")
    public RequestEntity<String> findAllContacts() {
        return null;
    }

}

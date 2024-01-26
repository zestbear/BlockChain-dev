package com.automated.trading.stock.StockManager.stock.contact.dto;

import com.automated.trading.stock.StockManager.stock.contact.ContactResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {

    // Contact 문의
    private String request_title;
    private String request_content;

    // 답변
    private String response_title;
    private String response_content;

    private ContactResponseType contactResponseType;

}

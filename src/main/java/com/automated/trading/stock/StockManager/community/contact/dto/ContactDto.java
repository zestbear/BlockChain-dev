package com.automated.trading.stock.StockManager.community.contact.dto;

import com.automated.trading.stock.StockManager.community.contact.ContactResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {

    private int contact_id;

    // Contact 문의
    private String request_title;
    private String request_content;

    // 답변
    private String response_title;
    private String response_content;

    private String cntc_dt;
    private ContactResponseType response_type;

}

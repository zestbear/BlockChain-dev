package com.automated.trading.stock.StockManager.community.contact.controller.dto;

import com.automated.trading.stock.StockManager.community.contact.domain.ContactResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactSetStateRequestDto {

    private ContactResponseType response_type;

    private String response_title;
    private String response_content;

}

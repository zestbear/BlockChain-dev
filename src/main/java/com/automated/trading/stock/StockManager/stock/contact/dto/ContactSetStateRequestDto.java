package com.automated.trading.stock.StockManager.stock.contact.dto;

import com.automated.trading.stock.StockManager.stock.contact.ContactResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactSetStateRequestDto {

    private ContactResponseType contactResponseType;

    private String response_title;
    private String response_content;

}

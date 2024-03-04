package com.automated.trading.stock.StockManager.community.contact.controller.dto;

import com.automated.trading.stock.StockManager.community.contact.domain.ContactResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReturnContactResponseDto {

    private String response_title;
    private String response_content;

    private ContactResponseType response_type;

}

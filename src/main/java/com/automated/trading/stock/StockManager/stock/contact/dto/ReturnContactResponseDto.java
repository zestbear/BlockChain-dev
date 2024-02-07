package com.automated.trading.stock.StockManager.stock.contact.dto;

import com.automated.trading.stock.StockManager.stock.contact.ContactResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReturnContactResponseDto {

    private int contact_id;

    private String request_title;
    private String request_content;

    private String response_title;
    private String response_content;

    private ContactResponseType response_type;
    private String wrt_dt;

}

package com.automated.trading.stock.StockManager.community.contact.service;

import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactHoldRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ReturnContactResponseDto;

import java.util.List;

public interface ContactService {

    void sendContact(ContactSendRequestDto dto);

    void respondContact(ContactHoldRequestDto dto);

    List<ReturnContactResponseDto> findAllContacts();

    void setHold(int contact_id);

    ReturnContactResponseDto findById(int contact_id);

}

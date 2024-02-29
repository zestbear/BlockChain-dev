package com.automated.trading.stock.StockManager.community.contact.service;

import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactSetStateRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ReturnContactResponseDto;

import java.util.List;

public interface ContactService {

    public void sendContact(ContactSendRequestDto dto);

    public void respondContact(ContactSetStateRequestDto dto);

    public List<ReturnContactResponseDto> findAllContacts();

    public ReturnContactResponseDto findById(int contact_id);

}

package com.automated.trading.stock.StockManager.community.contact;

import com.automated.trading.stock.StockManager.community.contact.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.community.contact.dto.ContactSetStateRequestDto;
import com.automated.trading.stock.StockManager.community.contact.dto.ReturnContactResponseDto;

import java.util.List;

public interface ContactService {

    public void sendContact(ContactSendRequestDto dto);

    public void respondContact(ContactSetStateRequestDto dto);

    public List<ReturnContactResponseDto> findAllContacts();

    public ReturnContactResponseDto findById(int contact_id);

}

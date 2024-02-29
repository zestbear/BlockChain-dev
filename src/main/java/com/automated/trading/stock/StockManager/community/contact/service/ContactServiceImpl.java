package com.automated.trading.stock.StockManager.community.contact.service;

import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactSetStateRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ReturnContactResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Override
    public void sendContact(ContactSendRequestDto dto) {
    }

    @Override
    public void respondContact(ContactSetStateRequestDto dto) {
    }

    @Override
    public List<ReturnContactResponseDto> findAllContacts() {
        return null;
    }

    @Override
    public ReturnContactResponseDto findById(int contact_id) {
        return null;
    }

}

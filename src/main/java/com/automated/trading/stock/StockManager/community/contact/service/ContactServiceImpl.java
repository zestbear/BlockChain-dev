package com.automated.trading.stock.StockManager.community.contact.service;

import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.community.contact.controller.dto.ContactHoldRequestDto;
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
    public void respondContact(ContactHoldRequestDto dto) {
    }

    @Override
    public List<ReturnContactResponseDto> findAllContacts() {
        return null;
    }

    /**
     * Update Jpql 쿼리 작성 필요
     */
    @Override
    public void setHold(int contact_id) {}

    @Override
    public ReturnContactResponseDto findById(int contact_id) {
        return null;
    }

}

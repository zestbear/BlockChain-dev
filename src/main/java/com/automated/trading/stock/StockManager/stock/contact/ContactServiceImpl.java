package com.automated.trading.stock.StockManager.stock.contact;

import com.automated.trading.stock.StockManager.stock.contact.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.stock.contact.dto.ContactSetStateRequestDto;
import com.automated.trading.stock.StockManager.stock.contact.dto.ReturnContactResponseDto;
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

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

    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public void sendContact(ContactSendRequestDto dto) {
        contactMapper.sendContact(dto);
    }

    @Override
    public void respondContact(ContactSetStateRequestDto dto) {
        contactMapper.respondContact(dto);
    }

    @Override
    public List<ReturnContactResponseDto> findAllContacts() {
        return contactMapper.findAllContacts();
    }

    @Override
    public ReturnContactResponseDto findById(int contact_id) {
        return contactMapper.findById(contact_id);
    }

}

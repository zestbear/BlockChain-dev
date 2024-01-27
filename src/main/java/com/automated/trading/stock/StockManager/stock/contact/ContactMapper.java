package com.automated.trading.stock.StockManager.stock.contact;

import com.automated.trading.stock.StockManager.stock.contact.dto.ContactSendRequestDto;
import com.automated.trading.stock.StockManager.stock.contact.dto.ContactSetStateRequestDto;
import com.automated.trading.stock.StockManager.stock.contact.dto.ReturnContactResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactMapper {

    void sendContact(ContactSendRequestDto dto);

    void respondContact(ContactSetStateRequestDto dto);

    List<ReturnContactResponseDto> findAllContacts();

    ReturnContactResponseDto findById(int contact_id);

}

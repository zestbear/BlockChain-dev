package com.automated.trading.stock.StockManager.member.service;

import com.automated.trading.stock.StockManager.member.controller.dto.JoinRequestDto;
import com.automated.trading.stock.StockManager.member.controller.dto.LoginRequestDto;

public interface MemberService {

    public Boolean join(JoinRequestDto joinRequestDto);
    public Boolean login(LoginRequestDto loginRequestDto);
    public void leave(Long memberId);

}

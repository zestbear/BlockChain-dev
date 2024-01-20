package com.automated.trading.stock.StockManager.stock.member;

public interface MemberService {

    public Boolean join(JoinRequestDto joinRequestDto);
    public Boolean login(LoginRequestDto loginRequestDto);
    public void leave(Long memberId);

}

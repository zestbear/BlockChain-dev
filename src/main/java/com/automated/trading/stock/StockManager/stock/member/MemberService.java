package com.automated.trading.stock.StockManager.stock.member;

public interface MemberService {

    public Boolean join(MemberJoinRequestDto joinRequestDto);
    public Boolean login(MemberLoginRequestDto memberLoginRequestDto);
    public void leave(Long memberId);

}

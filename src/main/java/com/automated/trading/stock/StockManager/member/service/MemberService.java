package com.automated.trading.stock.StockManager.member.service;

import com.automated.trading.stock.StockManager.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long joinGeneral() {
        // TODO: Dto 작성 필요
    }
}

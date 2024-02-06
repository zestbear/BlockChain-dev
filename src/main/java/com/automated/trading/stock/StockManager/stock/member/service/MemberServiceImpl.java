package com.automated.trading.stock.StockManager.stock.member.service;

import com.automated.trading.stock.StockManager.stock.member.controller.MemberJoinRequestDto;
import com.automated.trading.stock.StockManager.stock.member.domain.Member;
import com.automated.trading.stock.StockManager.stock.member.domain.MemberRepository;
import com.automated.trading.stock.StockManager.util.exception.MemberDuplicatedException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * [ 사용자 저장 API ]
     * - 이미 존재하는 "email" 이라면 DuplicatedEmail_ERROR 발생
     * - 중복 "email" 이 존재하지 않는다면 database 저장
     */
    @Override
    public void join(MemberJoinRequestDto dto) {
        String toSaveEmail = dto.getEmail();
        Optional<Member> byEmail = memberRepository.findByEmail(toSaveEmail);
        if (byEmail.isPresent()) {
            throw new MemberDuplicatedException();
        } else {
            memberRepository.save(dto.toEntity());
        }
    }
}

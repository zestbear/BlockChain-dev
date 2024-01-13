package com.automated.trading.stock.StockManager.member.service;

import com.automated.trading.stock.StockManager.member.controller.dto.JoinRequestDto;
import com.automated.trading.stock.StockManager.member.controller.dto.LoginRequestDto;
import com.automated.trading.stock.StockManager.member.domain.Member;
import com.automated.trading.stock.StockManager.member.domain.MemberRepository;
import com.automated.trading.stock.StockManager.util.exception.MemberNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Boolean join(JoinRequestDto joinRequestDto) {   // 추후에 Query로 바뀔 예정
        if (findDuplicated(joinRequestDto.getLoginID())) {
            memberRepository.save(joinRequestDto.toEntity());
            return true;
        }
        return false;
    }

    public Boolean findDuplicated(String loginID) {
        Optional<Member> optional = memberRepository.findByMemberID(loginID);
        return optional.isPresent();
    }

    @Override
    public Boolean login(LoginRequestDto loginRequestDto) {   // 추후에 Query로 바뀔 예정
        Optional<Member> optional = memberRepository.findByMemberID(loginRequestDto.getLoginID());
        if (optional.isPresent()) {
            Member member = optional.get();
            return member.getLoginPW().equals(loginRequestDto.getLoginPW());
        }
        return false;
    }

    @Override
    public void leave(Long memberId) {   // 추후에 Query로 바뀔 예정
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotExistException("Member가 존재하지 않습니다."));
        memberRepository.delete(member);
    }

}

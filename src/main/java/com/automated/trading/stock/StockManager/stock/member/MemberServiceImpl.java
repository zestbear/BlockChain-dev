package com.automated.trading.stock.StockManager.stock.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Override
    public Boolean join(MemberJoinRequestDto joinRequestDto) {
        return null;
    }

    @Override
    public Boolean login(MemberLoginRequestDto memberLoginRequestDto) {
        return null;
    }

    @Override
    public void leave(Long memberId) {

    }

//    @Override
//    public Boolean join(MemberJoinRequestDto joinRequestDto) {   // 추후에 Query로 바뀔 예정
//        if (findDuplicated(joinRequestDto.getLoginID())) {
//            memberRepository.save(joinRequestDto.toEntity());
//            return true;
//        }
//        return false;
//    }
//
//    public Boolean findDuplicated(String loginID) {
//        Optional<Member> optional = memberRepository.findByMemberID(loginID);
//        return optional.isPresent();
//    }
//
//    @Override
//    public Boolean login(MemberLoginRequestDto memberLoginRequestDto) {   // 추후에 Query로 바뀔 예정
//        Optional<Member> optional = memberRepository.findByMemberID(memberLoginRequestDto.getLoginID());
//        if (optional.isPresent()) {
//            Member member = optional.get();
//            return member.getLoginPW().equals(memberLoginRequestDto.getLoginPW());
//        }
//        return false;
//    }
//
//    @Override
//    public void leave(Long memberId) {   // 추후에 Query로 바뀔 예정
//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new MemberNotExistException("Member가 존재하지 않습니다."));
//        memberRepository.delete(member);
//    }

}

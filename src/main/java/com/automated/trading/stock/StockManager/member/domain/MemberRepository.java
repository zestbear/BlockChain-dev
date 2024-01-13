package com.automated.trading.stock.StockManager.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.id = :memberId")
    Optional<Member> findById(@Param("memberId") Long memberId);

    @Query("SELECT m FROM Member m WHERE m.loginID = :loginID")
    Optional<Member> findByMemberID(@Param("loginID") String loginID);

}

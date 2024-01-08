package com.automated.trading.stock.StockManager.member.domain;

import com.automated.trading.stock.StockManager.asset.domain.Asset;
import com.automated.trading.stock.StockManager.member.domain.enumerate.MemberTradeType;
import com.automated.trading.stock.StockManager.member.domain.enumerate.MemberType;
import com.automated.trading.stock.StockManager.order.Order;
import com.automated.trading.stock.StockManager.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column // USER or ADMIN
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column // KRW or BTC
    @Enumerated(EnumType.STRING)
    private MemberTradeType memberTradeType;

    @OneToMany(mappedBy = "member") // 사용자가 보유 중인 종목들 + 정보 (평단, 개수 etc.)
    private ArrayList<Asset> assets;

    @OneToMany(mappedBy = "member") // 사용자가 전송한 주문 목록 -> 이후 batch로 하루마다 일괄적으로 orderLog로 전송
    private ArrayList<Order> orders;

    @OneToMany(mappedBy = "member") // 사용자가 작성한 게시글
    private ArrayList<Post> posts;

}
package com.automated.trading.stock.StockManager.member.domain;

import com.automated.trading.stock.StockManager.asset.Asset;
import com.automated.trading.stock.StockManager.member.domain.enumerate.MemberTradeType;
import com.automated.trading.stock.StockManager.member.domain.enumerate.MemberType;
import com.automated.trading.stock.StockManager.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberTradeType memberTradeType;

    @OneToMany(mappedBy = "member")
    private Asset asset;

    @OneToMany(mappedBy = "member")
    private Order order;

}

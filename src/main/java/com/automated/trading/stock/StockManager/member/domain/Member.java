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

    @Column
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberTradeType memberTradeType;

    @OneToMany(mappedBy = "member")
    private ArrayList<Asset> assets;

    @OneToMany(mappedBy = "member")
    private ArrayList<Order> orders;

    @OneToMany(mappedBy = "member")
    private ArrayList<Post> posts;

}
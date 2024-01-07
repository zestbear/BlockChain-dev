package com.automated.trading.stock.StockManager.member.domain;

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
    private String memberType;

    @Column
    @Enumerated(EnumType.STRING)
    private String memberTradeType;

    @OneToMany(mappedBy = "asset_id")
    private Asset asset;

    @OneToMany(mappedBy = "order_id")
    private Order order;

}

package com.automated.trading.stock.StockManager.post;

import com.automated.trading.stock.StockManager.member.domain.Member;
import com.automated.trading.stock.StockManager.post.enumerate.PostType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private PostType postType;

    @Column(length = 500)
    private String title;

    @Column(length = 2000)
    private String content;

    @Column
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}

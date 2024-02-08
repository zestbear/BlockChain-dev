package com.automated.trading.stock.StockManager.stock.comment.domain;

import com.automated.trading.stock.StockManager.stock.comment.controller.dto.ReturnCommentResponseDto;
import com.automated.trading.stock.StockManager.stock.member.domain.Member;
import com.automated.trading.stock.StockManager.stock.qna.domain.Qna;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String content;

    private int recommends;

    // 단방향 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name")
    private Member member;

    // 양방향 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qna_id")
    private Qna qna;

    @Builder
    public Comment(String content, Member member, Qna qna) {
        this.content = content;
        this.recommends = 0;
        this.member = member;
        this.qna = qna;
    }

    public ReturnCommentResponseDto toEntity() {
        return ReturnCommentResponseDto.builder()
                .content(this.content)
                .writer(this.member.getName())
                .recommends(this.recommends)
                .build();
    }

}

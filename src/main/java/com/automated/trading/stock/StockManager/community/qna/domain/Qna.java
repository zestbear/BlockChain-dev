package com.automated.trading.stock.StockManager.community.qna.domain;

import com.automated.trading.stock.StockManager.community.comment.domain.Comment;
import com.automated.trading.stock.StockManager.community.member.domain.Member;
import com.automated.trading.stock.StockManager.community.qna.controller.dto.ReturnQnaResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    private Long id;

    private String title;

    private String content;

    private LocalDateTime wrt_dt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime mod_dt;

    private Boolean secret;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    @OneToMany(mappedBy = "qna")
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Qna(String title, String content, Boolean secret, Member writer) {
        this.title = title;
        this.content = content;
        this.secret = secret;
        this.writer = writer;
        this.wrt_dt = LocalDateTime.now();
        this.mod_dt = null;
    }

    public ReturnQnaResponseDto toEntity() {
        return ReturnQnaResponseDto.builder()
                .title(this.title)
                .content(this.content)
                .wrt_dt(this.wrt_dt.toString())
                .mod_dt(this.mod_dt.toString())
                .secret(this.secret)
                .build();
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

}

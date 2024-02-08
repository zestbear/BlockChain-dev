package com.automated.trading.stock.StockManager.stock.notice.domain;

import com.automated.trading.stock.StockManager.stock.member.domain.Member;
import com.automated.trading.stock.StockManager.stock.notice.controller.dto.ReturnNoticeResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    private String title;

    private String content;

    private LocalDateTime wrt_dt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime mod_dt;

    private Boolean imprtnc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    @Builder
    public Notice(String title, String content, Boolean imprtnc, Member writer) {
        this.title = title;
        this.content = content;
        this.imprtnc = imprtnc;
        this.writer = writer;
        this.wrt_dt = LocalDateTime.now();
        this.mod_dt = null;
    }

    public ReturnNoticeResponseDto toEntity() {
        return ReturnNoticeResponseDto.builder()
                .title(this.title)
                .content(this.content)
                .wrt_dt(this.wrt_dt.toString())
                .mod_dt(this.mod_dt.toString())
                .imprtnc(this.imprtnc)
                .build();
    }

}

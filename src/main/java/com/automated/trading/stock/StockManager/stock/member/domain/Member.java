package com.automated.trading.stock.StockManager.stock.member.domain;

import com.automated.trading.stock.StockManager.stock.notice.domain.Notice;
import com.automated.trading.stock.StockManager.stock.qna.domain.Qna;
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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    private String picture;

    private MemberRole role;

    private LocalDateTime created_dt;

    @OneToMany(mappedBy = "writer")
    private List<Notice> noticeList = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Qna> qnaList = new ArrayList<>();

    @Builder
    public Member(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = MemberRole.USER;
        this.created_dt = LocalDateTime.now();
    }

    public void addNotice(Notice notice) {
        this.noticeList.add(notice);
    }

    public void addQna(Qna qna) {
        this.qnaList.add(qna);
    }

}

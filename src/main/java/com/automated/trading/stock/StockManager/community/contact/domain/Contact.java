package com.automated.trading.stock.StockManager.community.contact.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private ContactResponseType type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contacted_at;

    @Builder
    public Contact(String title, String content) {
        this.title = title;
        this.content = content;
        this.type = ContactResponseType.notChecked;
        this.contacted_at = LocalDateTime.now();
    }

}

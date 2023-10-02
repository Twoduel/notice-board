package com.example.noticeboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    Article(){
        //롬복으로 간단히 줄이는 방법 : @NoArgsConstructor
    }

    // 리다이렉트에 필요한 메서드.
    public Long getID() {
        return id;
    }

}

package com.example.noticeboard.dto;

import com.example.noticeboard.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;  // 제목을 받을 피드
    private String content; // 내용을 받을 피드
    public Article toEntity() {
        return new Article(null, title, content);
    }
}

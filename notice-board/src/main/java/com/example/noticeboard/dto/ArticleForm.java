package com.example.noticeboard.dto;

import com.example.noticeboard.entity.Article;

public class ArticleForm {
    private String title;  // 제목을 받을 피드
    private String content; // 내용을 받을 피드

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public ArticleForm(String title, String content) {

        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}

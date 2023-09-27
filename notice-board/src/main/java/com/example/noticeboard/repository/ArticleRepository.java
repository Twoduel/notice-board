package com.example.noticeboard.repository;

import com.example.noticeboard.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}

package com.example.noticeboard.controller;

import com.example.noticeboard.dto.ArticleForm;
import com.example.noticeboard.entity.Article;
import com.example.noticeboard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){

        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        //System.out.println(form.toString());
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return"";
    }

    // 단일 데이터 조회하기.
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        // 1. id를 조회해 데이터 가져오기.
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 등록하기.
        model.addAttribute("article", articleEntity);

        // 3. 뷰 페이지 반환하기.
        return "articles/show";
    }

    //데이터 목록 조회하기.
    @GetMapping("/articles")  //index() 메서드가 수행되면서 뷰 페이지를 설정하는 코드들이 실행됨.
    public String index(Model model){
        // 1. DB에서 모든 Article 데이터 가져오기.
        ArrayList<Article> articleEntityList = articleRepository.findAll();

        // 2. 가져온 Article 묶음을 모델에 등록하기.
        model.addAttribute("articleList", articleEntityList);

        // 3. 사용자에게 보여 줄 뷰 페이지 설정하기.
        return "articles/index";
    }
}

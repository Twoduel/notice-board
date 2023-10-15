package com.example.noticeboard.service;

import com.example.noticeboard.dto.CommentDto;
import com.example.noticeboard.entity.Comment;
import com.example.noticeboard.repository.ArticleRepository;
import com.example.noticeboard.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;  // 댓글 리파지터리 객체 주입.
    @Autowired
    private ArticleRepository articleRepository;  // 게시글 리파지터리 객체 주입.

    public List<CommentDto> comments(Long articleId) {
        // 1. 댓글 조회.
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // 2. 엔티티 -> DTO 변환ȯ.
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for(int i=0; i<comments.size(); i++){
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }
        // 3. 결과 반환.
        return dtos;
    }
}

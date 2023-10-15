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
    private CommentRepository commentRepository;  // ��� �������͸� ��ü ����.
    @Autowired
    private ArticleRepository articleRepository;  // �Խñ� �������͸� ��ü ����.

    public List<CommentDto> comments(Long articleId) {
        // 1. ��� ��ȸ.
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // 2. ��ƼƼ -> DTO ��ȯ.
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for(int i=0; i<comments.size(); i++){
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }
        // 3. ��� ��ȯ.
        return dtos;
    }
}

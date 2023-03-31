package com.cslink.service.impl;

import com.cslink.domain.Comment;
import com.cslink.mapper.CommentMapper;
import com.cslink.service.ICommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    CommentMapper commentMapper;
    @Override
    public List<Comment> queryCommentByArticleId(Integer articleId) {
        return commentMapper.queryCommentByArticleId(articleId);
    }
}

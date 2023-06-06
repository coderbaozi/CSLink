package com.cslink.service.impl;

import com.cslink.domain.Comment;
import com.cslink.domain.dto.CommentDTO;
import com.cslink.domain.vo.CommentVo;
import com.cslink.mapper.CommentMapper;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ICommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    CommentMapper commentMapper;
    @Resource
    SysUserMapper sysUserMapper;
    @Override
    public List<CommentDTO> queryCommentByArticleId(Integer articleId) {
        List<CommentDTO> commentDTOS = commentMapper.queryCommentByArticleId(articleId);
        commentDTOS.forEach(item->{
        item.setUsername(sysUserMapper.queryUserNameById(item.getUserId()).getUsername());
        if(item.getToUid()!=null) {
            item.setToUsername(sysUserMapper.queryUserNameById(item.getToUid()).getUsername());
        }
        });

        return commentDTOS;
    }

    @Override
    public Integer saveComment(CommentDTO comment) {
        return commentMapper.insertComment(
            comment.getArticleId(),
            comment.getUserId(),
            comment.getContent(),
            comment.getToUid(),
            comment.getCommentTime(),
            comment.getParentId()
        );
    }

    @Override
    public Comment getLastComment(Integer articleId) {
        Comment comment = commentMapper.queryLastCommentUser(articleId);
        return comment;
    }
}

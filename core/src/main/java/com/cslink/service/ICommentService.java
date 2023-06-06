package com.cslink.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cslink.domain.Comment;
import com.cslink.domain.dto.CommentDTO;
import com.cslink.domain.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentService{
    List<CommentDTO> queryCommentByArticleId(Integer articleId);

    Integer saveComment(CommentDTO comment);

    Comment getLastComment(Integer articleId);
}

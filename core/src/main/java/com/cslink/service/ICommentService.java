package com.cslink.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cslink.domain.Comment;
import com.cslink.domain.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentService{
    List<CommentDTO> queryCommentByArticleId(Integer articleId);
}

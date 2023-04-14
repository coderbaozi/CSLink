package com.cslink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.Comment;
import com.cslink.domain.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    List<CommentDTO> queryCommentByArticleId(@Param("articleId")Integer articleId);
}

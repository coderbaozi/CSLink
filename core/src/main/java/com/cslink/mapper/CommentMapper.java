package com.cslink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> queryCommentByArticleId(@Param("articleId")Integer articleId);
}

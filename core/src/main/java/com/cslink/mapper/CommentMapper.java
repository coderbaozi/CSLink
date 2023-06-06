package com.cslink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.Comment;
import com.cslink.domain.dto.CommentDTO;
import com.cslink.domain.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    List<CommentDTO> queryCommentByArticleId(@Param("articleId")Integer articleId);

    Integer insertComment(
            @Param("articleId") Integer articleId,
            @Param("userId") Integer userId,
            @Param("content") String content,
            @Param("toUid") Integer toUid,
            @Param("commentTime")Date commentTime,
            @Param("parentId")Integer parentId
            );

    Comment queryLastCommentUser(@Param("articleId")Integer articleId);
}

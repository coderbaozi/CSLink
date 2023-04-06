package com.cslink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.ArticleContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleContentMapper extends BaseMapper<ArticleContent> {
    ArticleContent queryArticleContentByArticleId(@Param("articleId")Integer articleId);

    Integer saveArticleContent(@Param("articleId")Integer articleId,@Param("content")String content);
}

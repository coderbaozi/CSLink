package com.cslink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.Article;
import com.cslink.domain.dto.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> queryPageArticleListByTag(@Param("tagId") Integer tagId,@Param("offset") Integer offset,@Param("pageSize")Integer pageSize);
    Integer saveArticle(@Param("title")String title, @Param("createTime") Date createTime, @Param("userId")Integer userId, @Param("tagId")Integer tagId, @Param("cover")String cover);
    Integer queryArticleId(@Param("userId")Integer userId,@Param("title")String title);

    ArticleDTO queryArticleById(@Param("articleId")Integer articleId);
}

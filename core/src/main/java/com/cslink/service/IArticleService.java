package com.cslink.service;


import com.cslink.domain.Article;
import com.cslink.domain.dto.ArticleDTO;
import com.cslink.domain.vo.ArticleVo;

import java.util.List;

public interface IArticleService {
    List<Article> getArticleListByTag(Integer tagId,Integer offset,Integer pageSize);
    Integer queryArticleId(Integer userId,String title);
    Integer saveArticle(ArticleVo article,String token);

    ArticleDTO queryArticleById(Integer articleId);
}

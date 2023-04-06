package com.cslink.service.impl;

import com.cslink.domain.Article;
import com.cslink.domain.ArticleContent;
import com.cslink.domain.dto.ArticleDTO;
import com.cslink.domain.vo.ArticleVo;
import com.cslink.mapper.ArticleContentMapper;
import com.cslink.mapper.ArticleMapper;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.IArticleService;
import com.cslink.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleContentMapper articleContentMapper;

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<Article> getArticleListByTag(Integer tagId, Integer offset, Integer pageSize) {
        List<Article> articles = articleMapper.queryPageArticleListByTag(tagId,(offset-1)*pageSize,pageSize);
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            articles.get(i).setUsername(sysUserMapper.queryUserNameById(article.getUserId()).getUsername());
        }
        return articles;
    }

    @Override
    public ArticleDTO queryArticleById(Integer articleId) {
        ArticleContent articleContent = articleContentMapper.queryArticleContentByArticleId(articleId);
        ArticleDTO articleDTO = articleMapper.queryArticleById(articleId);
        articleDTO.setArticleContent(articleContent);
        String username = sysUserMapper.queryUserNameById(articleDTO.getUserId()).getUsername();
        articleDTO.setUsername(username);
        return articleDTO;
    }

    @Override
    public Integer queryArticleId(Integer userId,String title) {
        Integer articleId = articleMapper.queryArticleId(userId,title);
        return articleId;
    }

    @Override
    public Integer saveArticle(ArticleVo article,String token) {
        // 根据token查询userid 拿到token解析出的email
        String email = JWTUtil.getEmailFromToken(token);
        Integer userId = sysUserMapper.queryUserIdByEmail(email).getUserId();
        article.setUserId(userId);
        articleMapper.saveArticle(article.getTitle(),article.getCreateTime(),article.getUserId(),article.getTagId(),article.getCover());
        Integer articleId = articleMapper.queryArticleId(article.getUserId(),article.getTitle());
        Integer effectedRow = articleContentMapper.saveArticleContent(articleId,article.getContent());
        return effectedRow;
    }

}

package com.cslink.controller;

import com.cslink.constants.ArticleMSG;
import com.cslink.domain.Article;
import com.cslink.domain.Tag;
import com.cslink.domain.dto.ArticleDTO;
import com.cslink.domain.dto.CommentDTO;
import com.cslink.domain.vo.ArticleVo;
import com.cslink.service.IArticleService;
import com.cslink.service.ICommentService;
import com.cslink.service.ITagService;
import com.cslink.service.RedisService;
import com.cslink.utils.AjaxResult;
import com.cslink.utils.RedisCache;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cslink.constants.RedisPrefix.ARTICLE_INFO;

@RestController
public class CoreController {

    @Resource
    RedisCache redisCache;
    @Resource
    IArticleService articleService;

    @Resource
    ITagService tagService;
    @Resource
    ICommentService commentService;

    @Resource
    RedisService redisService;
    @GetMapping("/getArticleList")
    public AjaxResult getArticleByTag(@RequestParam("tagId")Integer tagID,@RequestParam("page") Integer page){
        int PAGE_SIZE = 20;
        List<Article> articles = articleService.getArticleListByTag(tagID,page,PAGE_SIZE);
        return  AjaxResult.success(articles);
    }
    @GetMapping("/getArticle")
    public AjaxResult getArticle(@RequestParam("articleId")Integer articleId) {
        ArticleDTO articleDTO = articleService.queryArticleById(articleId);
//        redisCache.setCacheObject("articleId");
        redisService.saveViewRedis(articleId);
        System.out.println(redisCache.getCacheMap(ARTICLE_INFO+articleId));
        return AjaxResult.success(articleDTO);
    }

    @PostMapping("/saveArticle")
    public AjaxResult saveArticle(@RequestBody ArticleVo article,@RequestHeader("Authorization")String token){
        Integer effectedRow = articleService.saveArticle(article,token);
        if(effectedRow > 0){
            return AjaxResult.success(ArticleMSG.COMMITED);
        }
        // TODO AjaxError
        return AjaxResult.success("error");
    }

    @GetMapping("/getTags")
    public AjaxResult getTags(){
        List<Tag> tags = tagService.getTagList();
        return AjaxResult.success(tags);
    }

    @GetMapping("/getComment/{articleId}")
    public AjaxResult getComment(@PathVariable Integer articleId){
        List<CommentDTO> comment = commentService.queryCommentByArticleId(articleId);
        return AjaxResult.success(comment);
    }
}

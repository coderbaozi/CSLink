package com.cslink.controller;

import com.cslink.constants.ArticleMSG;
import com.cslink.domain.Article;
import com.cslink.domain.ArticleContent;
import com.cslink.domain.Comment;
import com.cslink.domain.Tag;
import com.cslink.domain.vo.ArticleVo;
import com.cslink.service.IArticleService;
import com.cslink.service.ICommentService;
import com.cslink.service.ITagService;
import com.cslink.utils.AjaxResult;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoreController {

    @Resource
    IArticleService articleService;
    @Resource
    ITagService tagService;
    @Resource
    ICommentService commentService;
    @GetMapping("/getArticleList")
    public AjaxResult getArticleByTag(@RequestParam("tagId")Integer tagID,@RequestParam("page") Integer page){
        int PAGE_SIZE = 20;
        List<Article> articles = articleService.getArticleListByTag(tagID,page,PAGE_SIZE);
        return  AjaxResult.success(articles);
    }
    @GetMapping("/getArticle")
    public AjaxResult getArticle(@RequestParam("articleId")Integer articleId) {
        ArticleContent articleContent = articleService.getArticleContent(articleId);
        return AjaxResult.success(articleContent);
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
        List<Comment> comment = commentService.queryCommentByArticleId(articleId);
        return AjaxResult.success(comment);
    }
}

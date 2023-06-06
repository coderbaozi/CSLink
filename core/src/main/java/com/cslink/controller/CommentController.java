package com.cslink.controller;

import com.cslink.domain.dto.CommentDTO;
import com.cslink.domain.vo.CommentVo;
import com.cslink.service.ICommentService;
import com.cslink.service.ISysUserService;
import com.cslink.utils.AjaxResult;
import com.cslink.utils.JWTUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Resource
    ICommentService commentService;

    @Resource
    ISysUserService sysUserService;

    @GetMapping("/getComment/{articleId}")
    public AjaxResult getComment(@PathVariable Integer articleId){
        List<CommentDTO> comment = commentService.queryCommentByArticleId(articleId);
        return AjaxResult.success(comment);
    }

    @PostMapping("/postComment")
    public AjaxResult postComment(@RequestBody CommentDTO comment,@RequestHeader("Authorization") String token) {
        // verify token and get userId
        String email = JWTUtil.getEmailFromToken(token);
        Integer userId = sysUserService.getUserIdByEmail(email);
        comment.setUserId(userId);
        Integer effect = commentService.saveComment(comment);
        if( effect < 1) {
            return AjaxResult.error("comment error");
        }
        return AjaxResult.success("comment success");
    }
}

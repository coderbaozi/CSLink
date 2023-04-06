package com.cslink.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo {
    private Integer userId;
    private String title;
    private Date createTime;
    private String content;
    private String cover;
    private Integer tagId;
}

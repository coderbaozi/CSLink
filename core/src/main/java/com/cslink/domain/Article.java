package com.cslink.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author baozi
 * @since 2023-03-29 20:57:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = 620699786315279836L;

    @TableId
    private Integer articleId;
    
    private String title;
    
    private Integer status;
    
    private Date createTime;
    
    private Integer userId;
    
    private Integer tagId;
    
    private Integer hotArticle;
    
    private Integer browseCount;
    
    private Integer likeCount;
    
    private Integer commentCount;

    private String cover;

    private String articleContent;

    private String username;
}


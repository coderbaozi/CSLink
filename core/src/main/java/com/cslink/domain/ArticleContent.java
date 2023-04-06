package com.cslink.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ArticleContent)实体类
 *
 * @author baozi
 * @since 2023-03-30 20:29:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleContent implements Serializable {
    private static final long serialVersionUID = -38171762690746457L;

    @TableId
    private Integer id;
    
    private String content;
    
    private Integer articleId;

    private Integer thankCount;

    private Integer trampleCount;

}


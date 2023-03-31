package com.cslink.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2023-03-30 14:59:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private static final long serialVersionUID = -53147340531412254L;
    
    private Integer articleId;
    
    private Integer userId;
    
    private Integer id;
    
    private Integer articleType;
    
    private String content;
    
    private Integer formUid;
    
    private Integer toUid;
    
    private String articleContent;
    
    private Date commentTime;

}


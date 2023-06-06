package com.cslink.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private Integer userId;

    private Integer articleId;

    private String content;

    private Integer toUid;

    private Integer parentId;
}

package com.cslink.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable {
        private static final long serialVersionUID = -53147340531412254L;

        private Integer articleId;

        private Integer userId;

        private Integer id;

        private Integer articleType;

        private String content;

        private Integer formUid;

        private Integer toUid;

        private Date commentTime;

        private String username;

        private String toUsername;
}

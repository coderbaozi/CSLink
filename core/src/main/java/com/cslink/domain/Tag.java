package com.cslink.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Tag)实体类
 *
 * @author makejava
 * @since 2023-03-31 20:39:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {
    private static final long serialVersionUID = 876800139865271247L;

    @TableId
    private Integer tagId;
    
    private String name;
    
    private Integer articleCount;

}


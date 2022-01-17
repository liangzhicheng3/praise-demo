package com.liangzhicheng.modules.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PraiseNumDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户key
     */
    private String key;

    /**
     * 点赞数量
     */
    private Integer praiseNum;

}

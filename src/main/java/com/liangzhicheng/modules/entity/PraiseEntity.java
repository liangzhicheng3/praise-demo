package com.liangzhicheng.modules.entity;

import com.liangzhicheng.common.enums.PraiseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class PraiseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 点赞用户id
     */
    private String userId;

    /**
     * 被点赞用户id
     */
    private String toId;

    /**
     * 点赞状态：0取消点赞，1点赞
     */
    private Integer status = PraiseEnum.NOT_PRAISE.getCode();

    public PraiseEntity(String userId, String toId, Integer status) {
        this.userId = userId;
        this.toId = toId;
        this.status = status;
    }

}

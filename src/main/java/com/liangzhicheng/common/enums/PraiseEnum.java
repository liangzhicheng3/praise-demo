package com.liangzhicheng.common.enums;

import lombok.Getter;

/**
 * 点赞枚举类
 * @author liangzhicheng
 */
@Getter
public enum PraiseEnum {

    NOT_PRAISE(0, "取消点赞"),
    PRAISE(1, "点赞");

    private Integer code;
    private String message;

    PraiseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

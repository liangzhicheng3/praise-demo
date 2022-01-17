package com.liangzhicheng.common.utils;

/**
 * redis工具类
 * @author liangzhicheng
 */
public class RedisKeyUtil {

    /**
     * 用户点赞数据的key
     */
    public static final String USER_PRAISE_KEY_MAP = "user_praise_key_map";

    /**
     * 用户被点赞数量的key
     */
    public static final String USER_PRAISE_NUM_KEY_MAP = "user_praise_num_key_map";

    /**
     * 拼接点赞用户id和被点赞用户id作为key
     * @param userId 点赞用户id
     * @param toId 被点赞用户id
     * @return 用户点赞数据的key
     */
    public static String splice(String userId, String toId){
        StringBuilder builder = new StringBuilder();
        builder.append(userId);
        builder.append(":");
        builder.append(toId);
        return builder.toString();
    }

}

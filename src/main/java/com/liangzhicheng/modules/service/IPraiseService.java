package com.liangzhicheng.modules.service;

import com.liangzhicheng.modules.entity.PraiseEntity;

import java.util.List;
import java.util.Map;

public interface IPraiseService {

    /**
     * 保存点赞
     * @param praise 点赞对象
     * @return 保存后点赞对象
     */
    PraiseEntity save(PraiseEntity praise);

    /**
     * 批量或修改，保存点赞列表
     * @param praiseList 点赞列表
     * @return 保存后点赞对象列表
     */
    List<PraiseEntity> save(List<PraiseEntity> praiseList);

    /**
     * 根据点赞用户id获取用户点赞列表
     * @param userId 点赞用户id
     * @return 返回点赞用户列表
     */
    Map<String, Object> getPraiseListByUserId(String userId);

    /**
     * 根据被点赞用户id获取用户被点赞列表
     * @param toId 被点赞用户id
     * @return 返回被点赞用户列表
     */
    Map<String, Object> getPraiseListByToId(String toId);

    /**
     * 根据点赞用户id和被点赞用户id获取点赞对象
     * @param userId 点赞用户id
     * @param toId 被点赞用户id
     * @return 返回点赞对象
     */
    PraiseEntity hasPraise(String userId, String toId);

    /**
     * 将redis中的点赞数据存储数据库
     */
    void savePraiseToDatabase();

    /**
     * 将redis中的点赞数量存储数据库
     */
    void savePraiseNumToDatabase();

}

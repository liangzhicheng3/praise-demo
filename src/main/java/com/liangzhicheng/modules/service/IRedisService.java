package com.liangzhicheng.modules.service;

import com.liangzhicheng.modules.entity.PraiseEntity;
import com.liangzhicheng.modules.entity.dto.PraiseNumDTO;

import java.util.List;

public interface IRedisService {

    /**
     * 保存点赞，状态为1
     * @param userId 点赞用户
     * @param toId 被点赞用户
     */
    void save(String userId, String toId);

    /**
     * 取消点赞，状态为0
     * @param userId 点赞用户id
     * @param toId 被点赞用户id
     */
    void cancel(String userId, String toId);

    /**
     * 删除点赞
     * @param userId 点赞用户id
     * @param toId 被点赞用户id
     */
    void delete(String userId, String toId);

    /**
     * 点赞数+1
     * @param toId 被点赞用户id
     */
    void increment(String toId);

    /**
     * 点赞数-1
     * @param toId 被点赞用户id
     */
    void decrement(String toId);

    /**
     * 获取点赞数据
     * @return 点赞记录列表
     */
    List<PraiseEntity> getPraiseData();

    /**
     * 获取点赞数量
     * @return 点赞数量列表
     */
    List<PraiseNumDTO> getPraiseNum();

}

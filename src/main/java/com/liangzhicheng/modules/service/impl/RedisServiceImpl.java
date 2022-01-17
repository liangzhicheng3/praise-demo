package com.liangzhicheng.modules.service.impl;

import com.liangzhicheng.common.enums.PraiseEnum;
import com.liangzhicheng.common.utils.RedisKeyUtil;
import com.liangzhicheng.modules.entity.PraiseEntity;
import com.liangzhicheng.modules.entity.dto.PraiseNumDTO;
import com.liangzhicheng.modules.service.IRedisService;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RedisServiceImpl implements IRedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(String userId, String toId) {
        String key = RedisKeyUtil.splice(userId, toId);
        redisTemplate.opsForHash().put(RedisKeyUtil.USER_PRAISE_KEY_MAP, key, PraiseEnum.PRAISE.getCode());
    }

    @Override
    public void cancel(String userId, String toId) {
        String key = RedisKeyUtil.splice(userId, toId);
        redisTemplate.opsForHash().put(RedisKeyUtil.USER_PRAISE_KEY_MAP, key, PraiseEnum.NOT_PRAISE.getCode());
    }

    @Override
    public void delete(String userId, String toId) {
        String key = RedisKeyUtil.splice(userId, toId);
        redisTemplate.opsForHash().delete(RedisKeyUtil.USER_PRAISE_KEY_MAP, key);
    }

    @Override
    public void increment(String toId) {
        redisTemplate.opsForHash().increment(RedisKeyUtil.USER_PRAISE_NUM_KEY_MAP, toId, 1);
    }

    @Override
    public void decrement(String toId) {
        redisTemplate.opsForHash().increment(RedisKeyUtil.USER_PRAISE_NUM_KEY_MAP, toId, -1);
    }

    @Override
    public List<PraiseEntity> getPraiseData() {
        Cursor<Map.Entry<Object, Object>> scan =
                redisTemplate.opsForHash().scan(RedisKeyUtil.USER_PRAISE_KEY_MAP, ScanOptions.NONE);
        List<PraiseEntity> praiseList = new ArrayList<>();
        while(scan.hasNext()){
            Map.Entry<Object, Object> entry = scan.next();
            String key = (String) entry.getKey();
            String[] result = key.split(":");
            String userId = result[0];
            String toId = result[1];
            Integer value = (Integer) entry.getValue();
            //组装点赞对象
            PraiseEntity praise = new PraiseEntity(userId, toId, value);
            praiseList.add(praise);
            //存储到list后从redis中删除
            redisTemplate.opsForHash().delete(RedisKeyUtil.USER_PRAISE_KEY_MAP, key);
        }
        return praiseList;
    }

    @Override
    public List<PraiseNumDTO> getPraiseNum() {
        Cursor<Map.Entry<Object, Object>> scan =
                redisTemplate.opsForHash().scan(RedisKeyUtil.USER_PRAISE_NUM_KEY_MAP, ScanOptions.NONE);
        List<PraiseNumDTO> praiseNumDTOList = new ArrayList<>();
        while(scan.hasNext()){
            Map.Entry<Object, Object> map = scan.next();
            //将点赞数量存储到PraiseNumDTO
            String key = (String) map.getKey();
            PraiseNumDTO praiseNum = new PraiseNumDTO(key, (Integer) map.getValue());
            praiseNumDTOList.add(praiseNum);
            //存储到list后从redis中删除
            redisTemplate.opsForHash().delete(RedisKeyUtil.USER_PRAISE_NUM_KEY_MAP, key);
        }
        return praiseNumDTOList;
    }

}

package com.liangzhicheng.modules.service.impl;

import com.liangzhicheng.modules.entity.PraiseEntity;
import com.liangzhicheng.modules.entity.dto.PraiseNumDTO;
import com.liangzhicheng.modules.service.IPraiseService;
import com.liangzhicheng.modules.service.IRedisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class PraiseServiceImpl implements IPraiseService {

    @Resource
    private IRedisService redisService;

    @Override
    public PraiseEntity save(PraiseEntity praise) {
        return null;
    }

    @Override
    public List<PraiseEntity> save(List<PraiseEntity> praiseList) {
        return null;
    }

    @Override
    public Map<String, Object> getPraiseListByUserId(String userId) {
        return null;
    }

    @Override
    public Map<String, Object> getPraiseListByToId(String toId) {
        return null;
    }

    @Override
    public PraiseEntity hasPraise(String userId, String toId) {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void savePraiseToDatabase() {
        List<PraiseEntity> praiseList = redisService.getPraiseData();
        for(Iterator<PraiseEntity> praises = praiseList.iterator(); praises.hasNext();){
            PraiseEntity praise = praises.next();
            PraiseEntity exist = this.hasPraise(praise.getUserId(), praise.getToId());
            if(exist == null){
                this.save(praise);
            }else{
                exist.setStatus(praise.getStatus());
                this.save(exist);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void savePraiseNumToDatabase() {
        List<PraiseNumDTO> praiseNumList = redisService.getPraiseNum();
        for(Iterator<PraiseNumDTO> praiseNums = praiseNumList.iterator(); praiseNums.hasNext();){
            PraiseNumDTO praiseNum = praiseNums.next();
            String key = praiseNum.getKey();
            //根据key（用户id）获取用户信息并保存点赞数量
        }
    }

}

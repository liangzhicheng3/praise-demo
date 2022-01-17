package com.liangzhicheng.schedule;

import com.liangzhicheng.modules.service.IPraiseService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 点赞执行定时器
 * @author liangzhicheng
 */
public class PraiseScheduleTask extends QuartzJobBean {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private IPraiseService praiseService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("[点赞服务] PraiseScheduleTask execute ... 时间：" + sdf.format(new Date()));
        //将redis中的点赞数据与点赞数量同步到数据库
//        praiseService.savePraiseToDatabase();
//        praiseService.savePraiseNumToDatabase();
    }

}

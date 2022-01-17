package com.liangzhicheng.config.quartz;

import com.liangzhicheng.schedule.TestScheduleTask;
import com.liangzhicheng.schedule.PraiseScheduleTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置类
 * @author liangzhicheng
 */
@Configuration
public class QuartzConfig {

    private static final String PRAISE_SCHEDULE_TASK = "praise_schedule_task";
    private static final String TEST_SCHEDULE_TASK = "test_schedule_task";

    @Bean
    public JobDetail jobDetailPraise(){
        return JobBuilder.newJob(PraiseScheduleTask.class)
                .withIdentity(PRAISE_SCHEDULE_TASK)
                .storeDurably()
                .build();
    }

    @Bean
    public JobDetail jobDetailTest(){
        return JobBuilder.newJob(TestScheduleTask.class)
                .withIdentity(TEST_SCHEDULE_TASK)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger triggerPraise(){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)
//                .withIntervalInHours(2)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(jobDetailPraise())
                .withIdentity(PRAISE_SCHEDULE_TASK)
                .withSchedule(builder)
                .build();
    }

    @Bean
    public Trigger triggerTest(){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
//                .withIntervalInHours(2)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(jobDetailTest())
                .withIdentity(TEST_SCHEDULE_TASK)
                .withSchedule(builder)
                .build();
    }

}

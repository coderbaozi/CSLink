package com.cslink.task;

import com.cslink.service.RedisService;
import jakarta.annotation.Resource;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class LikeTask extends QuartzJobBean {
    @Resource
    RedisService redisService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        redisService.saveViewToDB();
    }
}

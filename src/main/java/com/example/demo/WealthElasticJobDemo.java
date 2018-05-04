package com.example.demo;

import io.elasticjob.lite.api.ShardingContext;
import io.elasticjob.lite.api.simple.SimpleJob;

import java.util.Date;

/**
 * 简单job类型即可满足公司目前的业务需要
 */
public class WealthElasticJobDemo implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
       System.out.println(new Date() + " 准备执行定时任务了==》");
    }
}
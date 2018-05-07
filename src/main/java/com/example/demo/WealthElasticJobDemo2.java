package com.example.demo;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.Data;

import java.util.Date;

/**
 * 简单job类型即可满足公司目前的业务需要
 */
@Data
public class WealthElasticJobDemo2 implements SimpleJob {
    private String data;

    /**
     * 在这里，实现你的定时任务业务逻辑即可
     * @param context
     */
    @Override
    public void execute(ShardingContext context) {
       System.out.println(new Date() + "复杂点的对象  准备执行定时任务了==》" + data);
    }
}
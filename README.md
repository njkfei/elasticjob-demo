# 问题提出
各种etl非常分散，没有统一管理。不方便查问题。

# 使用方法

## 引入pom依赖
```$xslt
	<!-- import elastic-job lite core -->
		<dependency>
			<groupId>io.elasticjob</groupId>
			<artifactId>elastic-job-lite-core</artifactId>
			<version>${lasted.release.version}</version>
		</dependency>

		<!-- import other module if need -->
		<dependency>
			<groupId>io.elasticjob</groupId>
			<artifactId>elastic-job-lite-spring</artifactId>
			<version>${lasted.release.version}</version>
		</dependency>
```

## 编写job
实现SimpleJob即可。

```$xslt
/**
 * 简单job类型即可满足公司目前的业务需要
 */
public class WealthElasticJobDemo implements SimpleJob {

    /**
     * 在这里，实现你的定时任务业务逻辑即可
     * @param context
     */
    @Override
    public void execute(ShardingContext context) {
       System.out.println(new Date() + " 准备执行定时任务了==》");
    }
}
```

## 配置bean
```$xslt
  <!--configure registry center -->
    <!--配置注册中心，namespace非常重要，通过控制台管理时，名字公司必须一致，否则，看不到你想要的信息 -->
    <reg:zookeeper id="regCenter" server-lists="zookeeper:2181" namespace="wealth-job" base-sleep-time-milliseconds="1000" max-sleep-time-milliseconds="3000" max-retries="3" />

    <!--configure job -->
    <job:simple id="wealthElasticJobDemo" class="com.example.demo.WealthElasticJobDemo" registry-center-ref="regCenter" cron="0/10 * * * * ?" sharding-total-count="1"/>

```

> 程序应该可以启动了。

# job管理控制台
job管理控制台，连接zookeeper即可。注意，需要和名字空间namespace保持一致。

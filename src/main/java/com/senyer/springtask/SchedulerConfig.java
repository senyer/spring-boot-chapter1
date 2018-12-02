package com.senyer.springtask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableAsync
//@EnableScheduling //测试需要打开该注解
@Configuration
public class SchedulerConfig {
    /**
     * 	很关键：默认情况下 TaskScheduler 的 poolSize = 1
     *
     * @return 线程池
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }
    /**
     * @EnableScheduling注解表示开启对@Scheduled注解的解析；同时new ThreadPoolTaskScheduler()也是相当的关键，
	 * 	通过阅读过源码可以发现默认情况下的private volatile int poolSize = 1;
	 * 	这就导致了多个任务的情况下容易出现竞争情况（多个任务的情况下，如果第一个任务没执行完毕，后续的任务将会进入等待状态）。
		@EnableAsync注解表示开启@Async注解的解析；作用就是将串行化的任务给并行化了。
		（@Scheduled(cron = "0/1 * * * * *")假设第一次工作时间为2018-05-29 17:30:55，工作周期为3秒；
		如果不加@Async那么下一次工作时间就是2018-05-29 17:30:59；如果加了@Async下一次工作时间就是2018-05-29 17:30:56）
     */
}

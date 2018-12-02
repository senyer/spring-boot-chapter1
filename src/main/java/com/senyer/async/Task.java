package com.senyer.async;

import java.util.Random;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.senyer.springtask.SpringTaskDemo;

@Component
public class Task {
	public static Random random =new Random();
    private static final Logger log = LoggerFactory.getLogger(SpringTaskDemo.class);
    /*
     * @Async 实现了异步调用，注意注解@EnableAsync 不能少
     * @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
     * Future<String> 可以实现回调，不要回调就改为void，不做返回 返回AsyncResult对象
     */
    
    @Async
    public Future<String> doTaskOne() throws Exception {
        log.error("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.error("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }
    
    @Async
    public Future<String> doTaskTwo() throws Exception {
    	log.error("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.error("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }
    
    @Async
    public Future<String>  doTaskThree() throws Exception {
    	log.error("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.error("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
}
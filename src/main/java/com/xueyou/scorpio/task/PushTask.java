package com.xueyou.scorpio.task;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class PushTask {
    @PostConstruct
    public void init() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.submit(new PushMsg(1));
//        executorService.submit(new PushMsg(2));
//        executorService.submit(new PushMsg(3));
//        executorService.submit(new PushMsg(4));
        RateLimiter rateLimiter = RateLimiter.create(2);
    }
}

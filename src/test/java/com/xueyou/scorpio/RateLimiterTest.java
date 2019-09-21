package com.xueyou.scorpio;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(5, 3, TimeUnit.SECONDS);
//        RateLimiter rateLimiter = RateLimiter.create(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            double acquireCount = rateLimiter.acquire();
            System.out.println(acquireCount);
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
                }
            });
        }
        executorService.shutdown();
    }
}

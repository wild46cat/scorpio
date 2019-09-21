package com.xueyou.scorpio.task.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PushMsg implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(PushMsg.class.getSimpleName());

    private int number;

    public PushMsg() {
    }

    public PushMsg(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            logger.info("aa:{}", number);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                logger.info("error:{}", e);
            }
        }
    }
}

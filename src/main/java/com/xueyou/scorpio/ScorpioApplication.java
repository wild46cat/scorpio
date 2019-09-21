package com.xueyou.scorpio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class ScorpioApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScorpioApplication.class, args);
    }
}

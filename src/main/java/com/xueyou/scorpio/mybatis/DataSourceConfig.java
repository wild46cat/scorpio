package com.xueyou.scorpio.mybatis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

@Configuration
@ImportResource(locations = {"classpath:mybatis/datasource.xml"})
public class DataSourceConfig {
//    @Bean(name = "scorpioMaster")
//    @ConfigurationProperties(prefix = "spring.datasource.scorpio-master") // application.properteis中对应属性的前缀
//    public DataSource dataSource1() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "scorpioSlave")
//    @ConfigurationProperties(prefix = "spring.datasource.scorpio-slave") // application.properteis中对应属性的前缀
//    public DataSource dataSource2() {
//        return DataSourceBuilder.create().build();
//    }

}

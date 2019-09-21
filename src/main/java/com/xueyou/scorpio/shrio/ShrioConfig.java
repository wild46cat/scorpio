package com.xueyou.scorpio.shrio;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:shrio-config.xml"})
public class ShrioConfig {
}
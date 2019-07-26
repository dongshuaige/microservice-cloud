package com.sc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author java
 * @create 2019-07-25 14:33
 * @desc @RefreshScope//刷新数据源
 * @ClassName
 **/
@Configuration
public class DruidConfig {

    @RefreshScope//刷新数据源
    @ConfigurationProperties(prefix = "spring.datasource") //绑定数据源配置
    @Bean
    public DruidDataSource druid() {
        return new DruidDataSource();
    }
}

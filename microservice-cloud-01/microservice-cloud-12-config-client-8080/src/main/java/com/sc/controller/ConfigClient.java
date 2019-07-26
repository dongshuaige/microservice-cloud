package com.sc.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author java
 * @create 2019-07-24 17:45
 * @desc 读取到 GitHub 上的配置信息
 * @ClassName
 **/
@RestController
public class ConfigClient {
    //会从github中的microservice-config-application.yml中获取
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    //请求访问
    @RequestMapping("/config")
    public String getConfig() {
        String content = "applicationName:" + applicationName + ", port:" + port;
        System.out.println("content: " + content);
        return content;
    }


}

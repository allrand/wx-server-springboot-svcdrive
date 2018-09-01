package com.nousunde.wxma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.core.SpringVersion;


@SpringBootApplication
@EnableAutoConfiguration
//public class WxMaDemoApplication {
//    public static void main(String[] args) {
//        String springVersion = SpringVersion.getVersion();
//        System.out.println("SpringVersion    : " + springVersion);
//        String sbversion = SpringBootVersion.getVersion();
//        System.out.println("SpringBootVersion: " + sbversion);
//        SpringApplication.run(WxMaDemoApplication.class, args);
//    }
//}
public class WxMaDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //return super.configure(builder);
        return builder.sources(WxMaDemoApplication.class);
    }

    public static void main(String[] args){
        SpringApplication.run(WxMaDemoApplication.class, args);
    }
}

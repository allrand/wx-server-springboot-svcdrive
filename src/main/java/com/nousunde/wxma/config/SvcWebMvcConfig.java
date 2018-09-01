package com.nousunde.wxma.config;

import com.nousunde.wxma.interceptor.FicialAccessInterceptor;
import com.nousunde.wxma.interceptor.InavInfoInterceptor;
import com.nousunde.wxma.interceptor.UserSesnInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SvcWebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 从之前new SesnInterceptor()的方式，更改为标签声明，Spring平台自动注入
     */
    @Autowired
    private InavInfoInterceptor inavInfoInterceptor;

    @Autowired
    private FicialAccessInterceptor ficialAccessInterceptor;

    @Autowired
    private UserSesnInterceptor userSesnInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(userSesnInterceptor)
                .addPathPatterns("/session/**")
                .addPathPatterns("/user/**");

        registry.addInterceptor(ficialAccessInterceptor)
                .addPathPatterns("/info/**");

        registry.addInterceptor(inavInfoInterceptor)
                .addPathPatterns("/inav/**")
                .addPathPatterns("/admin/**");


        super.addInterceptors(registry);
    }

}

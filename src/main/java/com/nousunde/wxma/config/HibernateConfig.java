package com.nousunde.wxma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@Configuration
@PropertySource(value = "classpath:application.yml")
public class HibernateConfig {
    /**
     * The simplest and least verbose way to autowire your Hibernate SessionFactory
     * @return
     * @Author A10
     */
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }
}

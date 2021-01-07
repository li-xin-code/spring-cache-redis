package com.xiaoxin.springcacheredis.config;

import com.xiaoxin.springcacheredis.interceptor.CurrentLimitingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lx
 * @date 2021/1/5
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CurrentLimitingInterceptor currentLimitingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(currentLimitingInterceptor).addPathPatterns("/**");
    }
}

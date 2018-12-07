package com.whh.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author admin
 * @Date: 2018/12/6 17:20
 * @Description: 拦截器  拦截所有请求
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public IndexInterceptor indexInterceptor() {
        return new IndexInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(indexInterceptor()).addPathPatterns("/**");
    }

}

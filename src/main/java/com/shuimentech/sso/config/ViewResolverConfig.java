package com.shuimentech.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class ViewResolverConfig {
    @Bean
    public ViewResolver viewResolver(){
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(false);
        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".ftl");
        viewResolver.setRequestContextAttribute("req");
        return viewResolver;
    }
}

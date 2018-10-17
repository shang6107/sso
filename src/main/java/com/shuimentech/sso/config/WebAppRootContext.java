package com.shuimentech.sso.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebAppRootContext implements ServletContextInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("renew", "false");
        servletContext.setInitParameter("gateway", "false");
    }
}

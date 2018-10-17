package com.shuimentech.sso.config;

import filter.CasForInvokeContextFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListener(){
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> myListener = new ServletListenerRegistrationBean<>();
        myListener.setListener(new SingleSignOutHttpSessionListener());
        return myListener;
    }

    @Bean
    public FilterRegistrationBean singleSignOutFilter(){
        FilterRegistrationBean<SingleSignOutFilter> bean = new FilterRegistrationBean<>(new SingleSignOutFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
    @Bean
    public FilterRegistrationBean authenticationFilter(){
        FilterRegistrationBean<org.jasig.cas.client.authentication.AuthenticationFilter> bean = new FilterRegistrationBean<>(new org.jasig.cas.client.authentication.AuthenticationFilter());
        bean.addInitParameter("casServerLoginUrl", "http://localhost/cas/login");
        bean.addInitParameter("serverName", "http://localhost:8080/");
        bean.addUrlPatterns("/*");
        return bean;
    }
    @Bean
    public FilterRegistrationBean cas20ProxyReceivingTicketValidationFilter(){
        FilterRegistrationBean<Cas20ProxyReceivingTicketValidationFilter> bean = new FilterRegistrationBean<>(new Cas20ProxyReceivingTicketValidationFilter());
        bean.addInitParameter("casServerUrlPrefix", "http://localhost/cas/");
        bean.addInitParameter("serverName", "http://localhost:8080/");
        bean.addUrlPatterns("/*");
        return bean;
    }
    @Bean
    public FilterRegistrationBean assertionThreadLocalFilter(){
        FilterRegistrationBean<AssertionThreadLocalFilter> bean = new FilterRegistrationBean<>(new AssertionThreadLocalFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
    @Bean
    public FilterRegistrationBean casForInvokeContextFilter(){
        FilterRegistrationBean<CasForInvokeContextFilter> bean = new FilterRegistrationBean<>(new CasForInvokeContextFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
//    @Bean
//    public FilterRegistrationBean httpServletRequestWrapperFilter(){
//        FilterRegistrationBean<HttpServletRequestWrapperFilter> bean = new FilterRegistrationBean<>(new HttpServletRequestWrapperFilter());
//        bean.addUrlPatterns("/*");
//        return bean;
//    }


}

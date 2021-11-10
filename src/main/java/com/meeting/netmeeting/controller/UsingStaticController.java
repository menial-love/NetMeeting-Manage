package com.meeting.netmeeting.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class UsingStaticController extends WebMvcConfigurationSupport {
    // 虽然静态文件(css,js,图片)的默认路径是在static下，但是并没有包含static下的各个文件夹，当访问static下的文件夹下的文件时
    // springboot就不认识了，因此我们需要一个配置类来让springboot认识它
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // classpath是resource文件夹的路径
        // url格式为http://localhost:8080/static/**时会去访问                   classpath:/static/**(在addResourceLocations中配置)
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // url格式为http://localhost/** 时会访问classpath:/templates/**
        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");

    }
}
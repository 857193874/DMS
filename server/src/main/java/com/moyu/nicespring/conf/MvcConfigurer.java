package com.moyu.nicespring.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer{

    public void addInterceptors(InterceptorRegistry registry){

    }

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }

    public void addFormatters(FormatterRegistry registry){

    }

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/swagger3/index.html").setViewName("/index.html");
    }

    @Value("${web.upload.path}")
    private String uploadPath;


    private final static Logger LOGGER = LoggerFactory.getLogger(MvcConfigurer.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/uploads/**").addResourceLocations(
                "file:"+uploadPath);
        LOGGER.info("自定义静态资源目录、此处功能用于文件映射"+uploadPath);
    }
}

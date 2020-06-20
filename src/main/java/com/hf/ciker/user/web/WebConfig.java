package com.hf.ciker.user.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * @author ciker
 * @version 1.0
 * @date 2020/6/6 17:41
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{


    /**
     * 跨域支持
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    /**
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.html").addResourceLocations("classpath:/static/html/");
        registry.addResourceHandler("/*.js").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/*.css").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/*.fonts").addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("/*.img").addResourceLocations("classpath:/static/img/");
    }
}
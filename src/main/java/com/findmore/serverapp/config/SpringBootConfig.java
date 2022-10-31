package com.findmore.serverapp.config;

import com.findmore.serverapp.pipeline.LoggerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This is the class used to configure the Spring Framework.
 * Its here where the @Bean methods are defined.
 * As this class implements WebMvcConfigurer then it can override the
 * methods that add more Components to the Spring Pipeline.
 */

@Configuration
public class SpringBootConfig implements WebMvcConfigurer {

    /**
     * This @Bean adds the LoggerFilter class to the Filter pipeline.
     */

    @Bean
    public FilterRegistrationBean<LoggerFilter> beanLoggerFilterRegistration() {
        FilterRegistrationBean<LoggerFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LoggerFilter());
        registration.addUrlPatterns("/*");
        registration.setName("loggerFilter");
        return registration;
    }
}

package com.epos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class BeanConfiguration {
    @Bean
    public InternalResourceViewResolver setupResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); //  /WEB-INF/views/*.jsp
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

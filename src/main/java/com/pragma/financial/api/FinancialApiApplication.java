package com.pragma.financial.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Clock;

@SpringBootApplication
@EnableConfigurationProperties
public class FinancialApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FinancialApiApplication.class, args);
    }
    
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
    
    @Bean
    public String appName() {
        return "Financial API";
    }
}
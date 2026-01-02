package com.example.config;

import com.example.dialect.MyCustomDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DialectConfig {

    @Bean
    public MyCustomDialect myCustomDialect() {
        return new MyCustomDialect();
    }
}
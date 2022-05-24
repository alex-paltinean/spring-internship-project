package com.accenture.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean(value = "myString")
    public String getStringBean() {
        System.out.println("Initializing a method bean");
        return new String("I'm a bean");
    }
}

package com.accenture.springcore.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class Scheduler {

    @Scheduled(cron = "0 * * ? * *")
    public void generateReport(){
        System.out.println(System.currentTimeMillis());
    }
}

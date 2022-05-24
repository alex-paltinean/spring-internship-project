package com.accenture.springcore.jms;

import com.accenture.springcore.exception.FieldNotValidException;
import com.accenture.springcore.model.Job;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JobReceiver {

    @JmsListener(destination = "JobQueue", containerFactory = "myFactory")
    public void receiveMessage(Job job) {
        System.out.println("1. Received: " + job);
    }

//    @JmsListener(destination = "JobQueue")
//    public void receiveMessage1(Job job) {
//        System.out.println("2. Received: " + job);
//    }
}

package com.accenture.springcore.controller.job;

import com.accenture.springcore.model.Job;
import com.accenture.springcore.service.job.JobService;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    private final JmsTemplate jmsTemplate;

    @GetMapping
    public List<Job> findAll(@RequestParam(required = false) Integer level, @RequestParam(required = false) String name) {
        return jobService.findAllByLevelAndName(level, name);
    }

    @GetMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public Job findOne(@PathVariable Integer id) {
        return jobService.findById(id);
    }

    @PostMapping
    public Job create(@RequestBody Job job, Principal principal) {
        System.out.println(principal);
        return jobService.update(job);
    }

    @PostMapping("/send")
    public void send(@RequestBody Job job) {
        System.out.println("Sending a job");
        for (int i = 0; i < 10; i++) {
            jmsTemplate.convertAndSend("JobQueue", job);
        }
    }


}

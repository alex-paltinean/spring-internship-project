package com.accenture.springcore.controller.job;

import com.accenture.springcore.model.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/persons/{personId}/jobs")
public class UserJobController {

    List<Job> jobs = new ArrayList<>();

    @PostConstruct
    public void encode(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("pass123"));
        System.out.println(bCryptPasswordEncoder.encode("admin123"));
    }

    @GetMapping
    public ResponseEntity<List<Job>> getUsersJobs(
            @PathVariable Integer personId, @Valid GetUsersJobRequestParams params) {

        serviceMethod(personId, params);

        System.out.println("Filter jobs with level at least " + params.getMinLevel());
        throw new NoSuchElementException("From UserJobController");
//        return ResponseEntity.ok(Arrays.asList(new Job(1, "job1")));
    }

    public List<Job> serviceMethod(Integer personId, GetUsersJobRequestParams params) {
        Stream<Job> stream = jobs.stream()
                .filter(job -> job.getPerson().getId().equals(personId));

        if (params.getMinLevel() != null) {
            stream = stream.filter(job -> job.getLevel() > params.getMinLevel());
        }

        if (params.getName() != null) {
            stream = stream.filter(job -> job.getPerson().getName().equals(params.getName()));
        }
        return stream.collect(Collectors.toList());
    }

//    @GetMapping("/{jobId}")
//    public ResponseEntity<Job> getUsersJob(@PathVariable Integer personId, @PathVariable Integer jobId) {
//        return ResponseEntity.ok(new Job(1, "job1"));
//    }
}

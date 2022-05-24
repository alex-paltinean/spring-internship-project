package com.accenture.springcore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class Person extends BaseEntity{
    @Size(max = 100, message = "Name cannot exced 100 characters")
    @NotBlank(message = "Name must not be blank")
    private final String name;

    private final Integer id;
    private final List<Job> jobs;

    public Person(String name, Integer id, List<Job> jobs) {
        this.name = name;
        this.id = id;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}

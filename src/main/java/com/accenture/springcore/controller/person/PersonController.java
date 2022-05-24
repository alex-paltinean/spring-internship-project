package com.accenture.springcore.controller.person;

import com.accenture.springcore.model.Job;
import com.accenture.springcore.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private List<Person> persons = new ArrayList<>();
//    private List<Person> persons = Arrays.asList(new Person("Ane", 1), new Person("George", 2));

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(persons.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("From PersonController")));
    }

    @GetMapping("/{personId}/jobs/{jobId}")
    public ResponseEntity<Job> getUsersJob(@PathVariable Integer personId, @PathVariable Integer jobId) {
        System.out.println(personId);
        System.out.println(jobId);
        return ResponseEntity.ok(new Job("job1", 1));
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Validated CreatePersonRequest request) {
        int newId = persons.size();
        Person savedPerson = new Person(request.getName(), newId, null);
        persons.add(savedPerson);
        return ResponseEntity.created(URI.create("/" + newId)).body(savedPerson);
    }
}

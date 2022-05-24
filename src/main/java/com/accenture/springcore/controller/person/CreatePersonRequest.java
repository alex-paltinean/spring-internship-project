package com.accenture.springcore.controller.person;

import com.accenture.springcore.validator.ValidCreatePersonRequest;

@ValidCreatePersonRequest
public class CreatePersonRequest {
    private final String name;
    private final Integer age;

    public CreatePersonRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

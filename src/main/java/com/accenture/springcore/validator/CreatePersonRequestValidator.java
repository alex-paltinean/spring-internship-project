package com.accenture.springcore.validator;

import com.accenture.springcore.controller.person.CreatePersonRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreatePersonRequestValidator implements ConstraintValidator<ValidCreatePersonRequest, CreatePersonRequest> {
    @Override
    public boolean isValid(CreatePersonRequest createPersonRequest, ConstraintValidatorContext constraintValidatorContext) {
        boolean ageValid = createPersonRequest.getAge() > 0;
        if(!ageValid){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Age less than 0!").addConstraintViolation();
        }
        return ageValid;
    }
}

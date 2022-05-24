package com.accenture.springcore.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CreatePersonRequestValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCreatePersonRequest {

    String message() default "Invalid CreatePersonRequest";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

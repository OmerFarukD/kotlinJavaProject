package com.example.kotlinjavaproject.AOP.Aspects.Validation;

import com.example.kotlinjavaproject.AOP.CCS.Validation.AuthorAddValidator;
import com.example.kotlinjavaproject.Business.Constants.Messages.Messages;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AuthorAddValidator.class)
public @interface AuthorAddValidationRules {
    String message() default Messages.authorNameMustBeUnique;
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

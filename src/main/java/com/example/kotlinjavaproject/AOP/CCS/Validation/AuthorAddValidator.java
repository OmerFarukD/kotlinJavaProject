package com.example.kotlinjavaproject.AOP.CCS.Validation;

import com.example.kotlinjavaproject.AOP.Aspects.Validation.AuthorAddValidationRules;
import com.example.kotlinjavaproject.Dtos.Request.Author.AuthorAddDto;
import com.example.kotlinjavaproject.Repository.AuthorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorAddValidator implements ConstraintValidator<AuthorAddValidationRules, AuthorAddDto> {

    private final AuthorRepository authorRepository;
    @Override
    public boolean isValid(AuthorAddDto value, ConstraintValidatorContext context) {
        return this.authorRepository.countByNameEquals(value.getName()) <= 1;
    }
}

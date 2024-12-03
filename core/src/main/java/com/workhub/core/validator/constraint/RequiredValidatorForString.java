package com.workhub.core.validator.constraint;

import com.workhub.core.validator.Required;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidatorForString implements ConstraintValidator<Required, String> {


    @Override
    public void initialize(Required constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       return s != null && !s.isBlank();
    }
}

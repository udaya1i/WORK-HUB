package com.workhub.validator.constraint;

import com.workhub.validator.Required;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidatorForString implements ConstraintValidator<Required, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       return s != null && !s.isBlank();
    }
}

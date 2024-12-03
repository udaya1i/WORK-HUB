package com.workhub.core.validator;

import com.workhub.core.validator.constraint.RequiredValidatorForString;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = {RequiredValidatorForString.class})
public @interface Required {

    String message() default "Required!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}





















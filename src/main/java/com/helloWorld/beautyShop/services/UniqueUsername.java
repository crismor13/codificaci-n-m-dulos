package com.helloWorld.beautyShop.services;

import com.helloWorld.beautyShop.services.implementation.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "Username is already in use";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

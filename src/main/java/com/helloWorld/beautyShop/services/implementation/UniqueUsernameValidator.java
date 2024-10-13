package com.helloWorld.beautyShop.services.implementation;

import com.helloWorld.beautyShop.services.UniqueUsername;
import com.helloWorld.beautyShop.services.VisitorService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private VisitorService visitorService; // Tu servicio que interactúa con la base de datos

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        if (userName == null || userName.isEmpty()) {
            return true; // NotBlank se encargará de validar si está vacío
        }
        return !visitorService.existsByUsername(userName); // Retorna false si el nombre ya existe
    }
}

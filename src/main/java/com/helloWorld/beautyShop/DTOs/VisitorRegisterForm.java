package com.helloWorld.beautyShop.DTOs;

import com.helloWorld.beautyShop.services.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VisitorRegisterForm {

    @NotBlank(message = "Username is mandatory")
    @UniqueUsername(message = "Username is already in use")
    private String userName;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

}

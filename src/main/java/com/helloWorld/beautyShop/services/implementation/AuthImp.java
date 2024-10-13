package com.helloWorld.beautyShop.services.implementation;

import com.helloWorld.beautyShop.models.User;
import com.helloWorld.beautyShop.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthImp implements AuthService {

    @Autowired
    VisitorImp userService;

    public boolean authenticate(String username, String password) {

        Optional<User> userOptional = userService.getUserByUsername(username);
        // Check if user is present
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Use .equals() to compare string content
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

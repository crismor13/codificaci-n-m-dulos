package com.helloWorld.beautyShop.services;

import com.helloWorld.beautyShop.models.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

public interface VisitorService {
    public User saveUser(User newUser);
    boolean isAuthenticated(HttpSession session);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);
}

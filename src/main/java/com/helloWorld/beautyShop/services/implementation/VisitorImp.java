package com.helloWorld.beautyShop.services.implementation;

import com.helloWorld.beautyShop.models.User;
import com.helloWorld.beautyShop.repositories.VisitorRepository;
import com.helloWorld.beautyShop.services.VisitorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorImp implements VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public User saveUser(User newUser) {
        return visitorRepository.save(newUser);
    }

    @Override
    public boolean isAuthenticated(HttpSession session) {
        if ((session.getAttribute("isUserAuthenticated") != null) && ((Boolean)session.getAttribute("isUserAuthenticated"))) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) visitorRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return visitorRepository.findById(id);
    }

    @Override
    public  Optional<User> getUserByUsername(String username) {
        return visitorRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String userName) {
        return visitorRepository.existsByUsername(userName);
    }
}

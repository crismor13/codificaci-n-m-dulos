package com.helloWorld.beautyShop.repositories;

import com.helloWorld.beautyShop.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

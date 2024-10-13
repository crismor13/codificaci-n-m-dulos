package com.helloWorld.beautyShop.models;

import com.helloWorld.beautyShop.services.UniqueUsername;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(length = 50)
    private String password;

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }
}


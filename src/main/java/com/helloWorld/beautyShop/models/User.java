package com.helloWorld.beautyShop.models;

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

    @Column(unique = true, length = 50)
    private String username;

    @Column(length = 50)
    private String password;

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }
}


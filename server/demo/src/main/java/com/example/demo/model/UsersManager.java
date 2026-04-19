package com.example.demo.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UsersManager {

    private final DynamoDBMapper mapper;
    private final JWTManager jwt;
    private final EmailManager emailManager;

    public UsersManager(DynamoDBMapper mapper, JWTManager jwt, EmailManager emailManager) {
        this.mapper = mapper;
        this.jwt = jwt;
        this.emailManager = emailManager;
    }

    public String addUser(Users u) {
        Users existing = mapper.load(Users.class, u.getEmail());
        if (existing != null) {
            return "401::Email already exists";
        }

        mapper.save(u);
        return "200::User registered";
    }

    public String login(String email, String password) {
        Users u = mapper.load(Users.class, email);

        if (u == null || !u.getPassword().equals(password)) {
            return "401::Invalid credentials";
        }

        return "200::" + jwt.generateToken(email);
    }

    public String recoverPassword(String email) {
        Users u = mapper.load(Users.class, email);

        if (u == null) return "404::User not found";

        String msg = "Password: " + u.getPassword();

        return emailManager.sendEmail(email, "Recovery", msg);
    }
}
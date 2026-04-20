package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Users;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import java.util.Optional;

@Repository
public class UsersRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void save(Users user) {
        dynamoDBMapper.save(user);
    }

    public Optional<Users> findById(String email) {
        return Optional.ofNullable(
                dynamoDBMapper.load(Users.class, email)
        );
    }

    public int validateEmail(String email) {
        Users u = dynamoDBMapper.load(Users.class, email);
        return u != null ? 1 : 0;
    }

    public int validateCresentials(String email, String password) {
        Users u = dynamoDBMapper.load(Users.class, email);
        if (u != null && password.equals(u.getPassword())) {
            return 1;
        }
        return 0;
    }
}
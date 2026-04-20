package com.example.demo.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.model.Menus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusManager {

    private final DynamoDBMapper mapper;

    public MenusManager(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public List<Menus> getAllMenus() {
        return mapper.scan(Menus.class, new DynamoDBScanExpression());
    }
}
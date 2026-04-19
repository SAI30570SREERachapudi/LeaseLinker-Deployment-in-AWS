package com.example.demo.repository;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.model.*;

@Repository
public class MenusRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Menus> findByRole(int role) {

        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":val1", new AttributeValue().withN(String.valueOf(role)));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("#r = :val1")
                .addExpressionAttributeNamesEntry("#r", "role")
                .withExpressionAttributeValues(eav);

        List<Roles> roles = dynamoDBMapper.scan(Roles.class, scanExpression);

        List<Menus> menusList = new ArrayList<>();
        for (Roles r : roles) {
            if (r.getMenus() != null) {
                menusList.add(r.getMenus());
            }
        }
        return menusList;
    }

    public List<Menus> findAll() {
        return dynamoDBMapper.scan(Menus.class, new DynamoDBScanExpression());
    }
}
package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Property;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;
import java.util.Optional;

@Repository
public class PropertiesRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Property save(Property property) {
        dynamoDBMapper.save(property);
        return property;
    }

    public List<Property> findAll() {
        return dynamoDBMapper.scan(Property.class, new DynamoDBScanExpression());
    }

    public Optional<Property> findById(String id) {
        return Optional.ofNullable(dynamoDBMapper.load(Property.class, id));
    }

    public void deleteById(String id) {
        Property p = dynamoDBMapper.load(Property.class, id);
        if (p != null) {
            dynamoDBMapper.delete(p);
        }
    }
}
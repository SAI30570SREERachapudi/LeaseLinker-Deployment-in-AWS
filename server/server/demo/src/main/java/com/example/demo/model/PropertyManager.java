package com.example.demo.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.model.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyManager {

    private final DynamoDBMapper mapper;

    public PropertyManager(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Property create(Property p) {
        mapper.save(p);
        return p;
    }

    public Property get(String id) {
        return mapper.load(Property.class, id);
    }

    public void delete(String id) {
        Property p = new Property();
        p.setId(id);
        mapper.delete(p);
    }
}
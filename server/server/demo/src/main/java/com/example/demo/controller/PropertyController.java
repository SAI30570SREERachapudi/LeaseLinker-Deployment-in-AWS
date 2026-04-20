package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Property;
import com.example.demo.model.PropertyManager;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jobs")
public class PropertyController {

    @Autowired
    PropertyManager JM;

    @PostMapping("/upload")
    public String uploadProperty(
            @RequestParam("nameOfOwner") String nameOfOwner,
            @RequestParam("contact") String contact,
            @RequestParam("state") String state,
            @RequestParam("location") String location,
            @RequestParam("propertyToBe") String propertyToBe,
            @RequestParam("cost") Double cost,
            @RequestParam("description") String description) {

        Property property = new Property();
        property.setNameOfOwner(nameOfOwner);
        property.setContact(contact);
        property.setState(state);
        property.setLocation(location);
        property.setPropertyToBe(propertyToBe);
        property.setCost(cost);
        property.setDescription(description);

        return JM.createJob(property);
    }

    @PostMapping("/create")
    public String create(@RequestBody Property property) {
        return JM.createJob(property);
    }

    @GetMapping("/read")
    public String read() {
        return JM.readJobs();
    }

    @GetMapping("/getdata/{id}")
    public String getData(@PathVariable("id") String id) {
        return JM.getData(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Property property) {
        return JM.updateJob(property);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        return JM.deleteJob(id);
    }
}
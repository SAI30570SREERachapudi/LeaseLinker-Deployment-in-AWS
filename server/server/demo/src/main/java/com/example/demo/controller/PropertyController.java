package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Property;
import com.example.demo.model.PropertyManager;
import com.example.demo.repository.PropertiesRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jobs")
public class PropertyController {
    @Autowired
    PropertyManager JM;
    @Autowired
    private PropertiesRepository JR;

    // Change the endpoint to handle image uploads
    @PostMapping("/upload")
    public String uploadProperty(
            @RequestParam("nameOfOwner") String nameOfOwner,
            @RequestParam("contact") String contact,
            @RequestParam("state") String state,
            @RequestParam("location") String location,
            @RequestParam("propertyToBe") String propertyToBe,
            @RequestParam("cost") Double cost,
            @RequestParam("description") String description
            ) {
        try {
         
            Property property = new Property();
            property.setNameOfOwner(nameOfOwner);
            property.setContact(contact);
            property.setState(state);
            property.setLocation(location);
            property.setPropertyToBe(propertyToBe);
            property.setCost(cost);
            property.setDescription(description);
              
            return JM.createJob(property);
        } catch (Exception e) {
            return "500::" + e.getMessage();
        }
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
    public String getData(@PathVariable("id") Long ID) {
        return JM.getData(ID);
    }
    

    @PutMapping("/update")
    public String update(@RequestBody Property property) {
        return JM.updateJob(property);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long ID) {
        return JM.deleteJob(ID);
    }
}

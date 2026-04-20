package com.example.demo.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PropertiesRepository;
import com.google.gson.GsonBuilder;
@Service
public class PropertyManager {
@Autowired
PropertiesRepository JR;
public String createJob(Property J)
{
  try
  {
    JR.save(J);
    return "200::New Property has been added";
  }catch(Exception e)
  {
    return "400::" + e.getMessage();
  }
}
public String readJobs() {
	try {
		List<Property> joblist=JR.findAll();
		return new GsonBuilder().create().toJson(joblist);
	}
	catch(Exception e) {
		return "400::" +e.getMessage();
	}
}
public String getData(Long id)
  {
    try
    {
    	Property J = JR.findById(id).get();
      return new GsonBuilder().create().toJson(J);
    }catch(Exception e)
    {
      return "404::"+e.getMessage();
    }
  }
public Property getPropertyById(Long id) {
    return JR.findById(id).orElse(null); // Fetch the property by its ID
}
public String updateJob(Property J) {
    try {
        Property existing = JR.findById(J.getId()).orElse(null);

        if (existing == null) {
            return "404::Property not found";
        }

        // Update fields manually
        existing.setNameOfOwner(J.getNameOfOwner());
        existing.setContact(J.getContact());
        existing.setState(J.getState());
        existing.setLocation(J.getLocation());
        existing.setPropertyToBe(J.getPropertyToBe());
        existing.setCost(J.getCost());
        existing.setDescription(J.getDescription());

        JR.save(existing);

        return "200::Property updated successfully";

    } catch (Exception e) {
        return "400::" + e.getMessage();
    }
}
public String deleteJob(Long id)
  {
    try
    {
      JR.deleteById(id);
      return "200::Property details has been deleted";
    }catch(Exception e)
    {
      return "404::" + e.getMessage();
    }
  }
}
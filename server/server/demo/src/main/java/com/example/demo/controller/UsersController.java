package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Users;
import com.example.demo.model.UsersManager;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersManager um;

    @PostMapping("/signup")
    public String signup(@RequestBody Users U) {
        return um.addUser(U);
    }

    @PostMapping("/signin")
    public String signin(@RequestBody Users U) {
        return um.ValidateCredentials(U.getEmail(), U.getPassword());
    }

    @GetMapping("/forgotpassword/{email}")
    public String forgotPassword(@PathVariable("email") String emailid) {
        return um.recoverPassword(emailid);
    }

    @PostMapping("/getfullname")
    public String getFullname(@RequestBody Map<String, String> data) {
        return um.getFullname(data.get("csrid"));
    }

    @PostMapping("/getemail")
    public String getEmail(@RequestBody Map<String, String> data) {
        return um.getEmail(data.get("csrid"));
    }
}
package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.MenusManager;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    MenusManager M;

    @PostMapping("/getmenus")
    public String getMenus() {
        return M.getMenus();
    }

    @PostMapping("/getmenusbyrole")
    public String getMenusByRole(@RequestBody Map<String, String> data) {
        return M.getMenusByRole(data.get("csrid"));
    }
}
package com.qpa.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpa.entity.UserInfo;
import com.qpa.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Add User
    @PostMapping("/add")
    public UserInfo addUser(@RequestBody UserInfo user) {
        System.out.println("inside the addUser controller");
        return userService.addUser(user);
    }

    // Add Vehicle to a User
    

    // Get User by ID
    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/viewAll")
    public List<UserInfo> getAllUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/{id}")
    public UserInfo updateUser(@PathVariable Long id, @RequestBody UserInfo user) {
        return userService.updateUser(id, user);
    }
    
}

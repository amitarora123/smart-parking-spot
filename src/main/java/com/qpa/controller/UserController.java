package com.qpa.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpa.entity.UserInfo;
import com.qpa.entity.Vehicle;
import com.qpa.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Add User
    @PostMapping("/add")
    public UserInfo addUser(@RequestBody UserInfo user) {
        return userService.addUser(user);
    }

    // Add Vehicle to a User
    @PostMapping("/{userId}/addVehicle")
    public Vehicle addVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        return userService.addVehicle(userId, vehicle);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/viewAll")
    public List<UserInfo> getAllUsers() {
        return userService.getAllUser();
    }
    
}

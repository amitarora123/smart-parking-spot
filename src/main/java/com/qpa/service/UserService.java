package com.qpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpa.entity.UserInfo;
import com.qpa.entity.Vehicle;
import com.qpa.repository.UserRepository;
import com.qpa.repository.VehicleRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    // Add User
    public UserInfo addUser(UserInfo user) {
        return userRepository.save(user);
    }

    // Add Vehicle to User
    public Vehicle addVehicle(Long userId, Vehicle vehicle) {
        Optional<UserInfo> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserInfo user = userOptional.get();
            vehicle.setUser(user);
            return vehicleRepository.save(vehicle);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }

    // View User by ID
    public UserInfo getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    public List<UserInfo> getAllUser(){
        return userRepository.findAll();
    }
}

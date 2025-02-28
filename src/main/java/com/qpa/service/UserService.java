package com.qpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpa.entity.UserInfo;
import com.qpa.entity.Vehicle;
import com.qpa.exception.CustomException;
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
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException("User already exists with email or phoneNumber: ", 400);
        }
    }

    // Add Vehicle to User
    public Vehicle addVehicle(Long userId, Vehicle vehicle) {
        Optional<UserInfo> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserInfo user = userOptional.get();
            vehicle.setUser(user);
            return vehicleRepository.save(vehicle);
        } else {
            throw new CustomException("User not found with ID: " + userId, 400);
        }
    }

    // View User by ID
    public UserInfo getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with ID: " + id, 400));
    }

    public List<UserInfo> getAllUser(){
        return userRepository.findAll();
    }

    public UserInfo updateUser(Long id, UserInfo user) {
        UserInfo existingUser = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with ID: " + id, 400));
       try {
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(existingUser);
       } catch (Exception e) {
              throw new CustomException("User already exists with email or phoneNumber: ", 400);
       }
    }
}

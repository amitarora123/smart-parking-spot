package com.qpa.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qpa.entity.UserInfo;
import com.qpa.exception.CustomException;
import com.qpa.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Add User
    public UserInfo addUser(UserInfo user) {
        try {
            // Hash the password before saving the user
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException("User already exists with email or phoneNumber.", 400);
        }
    }

    // View User by ID
    public UserInfo getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with ID: " + id, 400));
    }

    // Get All Users
    public List<UserInfo> getAllUser() {
        return userRepository.findAll();
    }

    // Update User
    public UserInfo updateUser(Long id, UserInfo user) {
        UserInfo existingUser = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with ID: " + id, 400));
    
        try {
            if (user.getFirstName() != null && !user.getFirstName().isEmpty()) {
                existingUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null && !user.getLastName().isEmpty()) {
                existingUser.setLastName(user.getLastName());
            }
            if (user.getEmailId() != null && !user.getEmailId().isEmpty()) {
                existingUser.setEmailId(user.getEmailId());
            }
            if (user.getContactNumber() != null && !user.getContactNumber().isEmpty()) {
                existingUser.setContactNumber(user.getContactNumber());
            }
            if (user.getAddress() != null && !user.getAddress().isEmpty()) {
                existingUser.setAddress(user.getAddress());
            }
    
            return userRepository.save(existingUser);
        } catch (Exception e) {
            throw new CustomException("User already exists with email or phone number.", 400);
        }
    }
    
}

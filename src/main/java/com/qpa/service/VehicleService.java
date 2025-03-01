package com.qpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qpa.entity.UserInfo;
import com.qpa.entity.Vehicle;
import com.qpa.entity.VehicleType;
import com.qpa.exception.CustomException;
import com.qpa.repository.UserRepository;
import com.qpa.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleService(VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    public Vehicle addVehicle(Long userId, Vehicle vehicle) {
        Optional<UserInfo> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserInfo user = userOptional.get();
            vehicle.setUser(user);
            try {
                return vehicleRepository.save(vehicle);
            } catch (Exception e) {
                throw new CustomException("registrationNumber already exist", 400);
            }
        } else {
            throw new CustomException("User not found with ID: " + userId, 400);
        }
    }

    public Vehicle getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new CustomException("Vehicle not found with ID: " + vehicleId, 400));
        vehicle.getUser().getUserId(); // Ensure userId is loaded
        vehicle.getUser().getUserName(); // Ensure username is loaded
        return vehicle;
    }

    public List<Vehicle> getVehicleByType(VehicleType vehicleType) {
        List<Vehicle> vehicles = vehicleRepository.findByVehicleType(vehicleType);
        vehicles.forEach(vehicle -> {
            vehicle.getUser().getUserId(); // Ensure userId is loaded
            vehicle.getUser().getUserName(); // Ensure username is loaded
        });
        return vehicles;
    }
}

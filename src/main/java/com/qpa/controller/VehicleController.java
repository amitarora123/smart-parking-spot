package com.qpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpa.entity.Vehicle;
import com.qpa.entity.VehicleType;
import com.qpa.service.VehicleService;



@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    // add vehicle
    @PostMapping("/{userId}/add")
    public Vehicle addVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(userId, vehicle);
    }

    // view vehicle by id

    @GetMapping("/view/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable Long vehicleId ) {
        return vehicleService.getVehicleById(vehicleId);
    }
    @GetMapping("/viewByType/{vehicleType}")
    public List<Vehicle> getVehiclesByType(@PathVariable VehicleType vehicleType){
        return vehicleService.getVehicleByType(vehicleType);
    }
    
}

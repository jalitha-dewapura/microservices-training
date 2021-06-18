package com.jalitha.rentcloud.vehicleservice.repository;


import com.jalitha.rentcloud.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}


package com.jalitha.rentcloud.vehicleservice.repository;

import com.jalitha.rentcloud.commons.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}

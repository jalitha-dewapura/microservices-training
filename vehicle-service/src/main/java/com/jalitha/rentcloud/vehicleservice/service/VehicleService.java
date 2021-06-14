package com.jalitha.rentcloud.vehicleservice.service;

import com.jalitha.rentcloud.commons.model.Vehicle;
import com.jalitha.rentcloud.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface VehicleService {

    Vehicle save(Vehicle vehicle);
    Vehicle fetchVehicle(int id);
    List fetchAllVehicles();

}

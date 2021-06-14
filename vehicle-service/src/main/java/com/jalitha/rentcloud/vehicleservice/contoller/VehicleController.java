package com.jalitha.rentcloud.vehicleservice.contoller;

import com.jalitha.rentcloud.commons.model.Vehicle;
import com.jalitha.rentcloud.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> fetchVehicle(@RequestParam int id) {
        Vehicle vehicle = vehicleService.fetchVehicle(id);
        if(vehicle == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(vehicle);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List fetchAllVehicles() {
        return vehicleService.fetchAllVehicles();
    }
}

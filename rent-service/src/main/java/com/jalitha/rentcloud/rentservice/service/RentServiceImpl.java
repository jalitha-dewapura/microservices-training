package com.jalitha.rentcloud.rentservice.service;

import com.jalitha.rentcloud.model.customer.Customer;
import com.jalitha.rentcloud.model.rent.Rent;
import com.jalitha.rentcloud.model.vehicle.Vehicle;
import com.jalitha.rentcloud.rentservice.hystrix.CommonHystrixCommand;
import com.jalitha.rentcloud.rentservice.hystrix.VehicleCommand;
import com.jalitha.rentcloud.rentservice.model.DetailResponse;
import com.jalitha.rentcloud.rentservice.repository.RentRepository;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    HystrixCommand.Setter setter;

    @Autowired
    RentRepository rentRepository;

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }


    @Override
    public Rent findById(int id) {
        Optional<Rent> rent = rentRepository.findById(id);

        if (rent.isPresent())
            return rent.get();
        else
            return new Rent();

    }


    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException {


        Rent rent=findById(id);
        Customer customer=getCustomer(rent.getCustomerId());
        Vehicle vehicle= getVehicle(rent.getVehicleId());

        return new DetailResponse(rent,customer,vehicle);


    }

    private Customer getCustomer(int customerId) throws ExecutionException, InterruptedException {
        CommonHystrixCommand<Customer> customerCommonHystrixCommand = new CommonHystrixCommand<Customer>(setter, () ->
        {
            return restTemplate.getForObject("http://customer/services/customers/"+customerId,Customer.class);
        }, () -> {
            return new Customer();
                });
        Future<Customer> customerFuture = customerCommonHystrixCommand.queue();
        return customerFuture.get();
    }

    private Vehicle getVehicle(int vehicleId){
        VehicleCommand vehicleCommand = new VehicleCommand(restTemplate , vehicleId);
        return vehicleCommand.execute();
        //return restTemplate.getForObject("http://vehicle/services/vehicles/"+vehicleId,Vehicle.class);


    }
}

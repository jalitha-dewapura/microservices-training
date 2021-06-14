package com.jalitha.rentcloud.profileservice.controller;

import com.jalitha.rentcloud.commons.model.Customer;
import com.jalitha.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<Customer> fetchCustomer(@RequestParam int id) {
        Customer customer = customerService.fetchCustomer(id);
        if( customer == null )
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(customer);
    }

    @RequestMapping(value="/profiles", method = RequestMethod.GET)
    public List fetchAllCustomers() {
        return customerService.fetchAllCustomers();
    }

}

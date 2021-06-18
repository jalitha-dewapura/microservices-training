package com.jalitha.rentcloud.profileservice.controller;

import com.jalitha.rentcloud.commons.model.Customer;
import com.jalitha.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_admin')")                              //using role based authenticate
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> fetchCustomer(@PathVariable(value = "id") int id) {
        Customer customer = customerService.fetchCustomer(id);
        if( customer == null )
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(customer);
    }

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")                       //using permission based authenticate
    public List fetchAllCustomers() {
        return customerService.fetchAllCustomers();
    }

}

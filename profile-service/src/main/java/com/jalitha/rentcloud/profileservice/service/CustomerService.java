package com.jalitha.rentcloud.profileservice.service;

import com.jalitha.rentcloud.commons.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer);
    public Customer fetchCustomer(int id);
    public List<Customer> fetchAllCustomers();
}

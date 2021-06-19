package com.jalitha.rentcloud.rentservice.service;

import com.jalitha.rentcloud.model.rent.Rent;
import com.jalitha.rentcloud.rentservice.model.DetailResponse;
import com.jalitha.rentcloud.rentservice.model.Response;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface RentService {
    Rent save(Rent customer);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException;
}

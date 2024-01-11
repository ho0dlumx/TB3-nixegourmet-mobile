package com.example.project_application.adapter;

import com.example.project_application.model.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CustomerAPI {

    @GET("/api/customers")
    Call<List<Customer>> getAllCustomers();

    @POST("/api/customers")
    Call<Customer> createCustomer(@Body Customer customer);
}

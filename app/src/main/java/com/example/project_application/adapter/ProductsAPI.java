package com.example.project_application.adapter;

import com.example.project_application.model.Customer;
import com.example.project_application.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductsAPI {
    @GET("/api/products")
    Call<List<Products>> getAllProducts();


}


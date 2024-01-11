package com.example.project_application;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application.adapter.CustomerAPI;
import com.example.project_application.adapter.ProductsAPI;
import com.example.project_application.adapter.ProductsAdapter;
import com.example.project_application.adapter.Retrofitservice;
import com.example.project_application.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class productsActivity  extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        recyclerView= findViewById(R.id.rvProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadProducts();
    }

    private void loadProducts() {
        Retrofitservice retrofitservice= new Retrofitservice();
        ProductsAPI productsAPI= retrofitservice.getRetrofit().create(ProductsAPI.class);

        productsAPI.getAllProducts()
                .enqueue(new Callback<List<Products>>() {
                    @Override
                    public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Products>> call, Throwable t) {
                        Toast.makeText(productsActivity.this, "Failed to load products",Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void populateListView(List<Products> productsList){
        ProductsAdapter productsAdapter= new ProductsAdapter(productsList);
        recyclerView.setAdapter(productsAdapter);

    }
}

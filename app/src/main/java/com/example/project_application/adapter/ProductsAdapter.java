package com.example.project_application.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application.R;
import com.example.project_application.model.Products;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsHolder> {

    private List<Products> productsList;

    public ProductsAdapter(List<Products> productsList) {
        this.productsList = productsList;
    }

    public ProductsHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType){
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item,parent,false);
        return new ProductsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsHolder holder, int position){
        Products products= productsList.get(position);
        holder.name.setText(products.getName());
        holder.description.setText(products.getDescription());
        holder.price.setText(String.valueOf(products.getPrice()));
    }

    @Override
    public int getItemCount(){
        return productsList.size();
    }
}

package com.example.project_application.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application.R;

public class ProductsHolder extends RecyclerView.ViewHolder {
    TextView name, description, price;


    public ProductsHolder (@NonNull View itemView){
        super(itemView);
        name=itemView.findViewById(R.id.tvProductName);
        description=itemView.findViewById(R.id.tvProductDescription);
        price=itemView.findViewById(R.id.tvProductPrice);
    }
}

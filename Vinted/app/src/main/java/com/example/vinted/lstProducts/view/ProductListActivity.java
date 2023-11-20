package com.example.vinted.lstProducts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vinted.R;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.bean.Producto;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity implements ContractListProducts.View {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        recyclerView = findViewById(R.id.recyclerView);
        Toast.makeText(getApplicationContext(), "Login correcto", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void successProducts(ArrayList<Producto> lstProducts) {
        ListProductsAdapter adapter = new ListProductsAdapter(lstProducts);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void failureProducts(String err) {

    }
}
package com.example.vinted.lstProducts.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.vinted.R;
import com.example.vinted.lstProducts.ContractListProducts;

public class ProductListActivity extends AppCompatActivity implements ContractListProducts.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
    }

    @Override
    public void lstProducts(String filtro) {

    }
}
package com.example.vinted.lstProducts.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.vinted.R;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.bean.Producto;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity implements ContractListProducts.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
    }

    @Override
    public void successProducts(ArrayList<Producto> lstProducts) {
        Toast.makeText(this, lstProducts, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureProducts(String err) {

    }
}
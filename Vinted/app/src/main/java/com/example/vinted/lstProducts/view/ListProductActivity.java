package com.example.vinted.lstProducts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vinted.R;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.ListProductsAdapter;
import com.example.vinted.beans.Producto;
import com.example.vinted.lstProducts.presenter.PresenterListProducts;

import java.util.ArrayList;

public class ListProductActivity extends AppCompatActivity implements ContractListProducts.View{
    private PresenterListProducts presenter = new PresenterListProducts(this);
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        recyclerView = findViewById(R.id.recicler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.lstProducts("");
    }

    @Override
    public void successProducts(ArrayList<Producto> lstProducts) {
        recyclerView.setAdapter(new ListProductsAdapter(lstProducts));

    }

    @Override
    public void failureProducts(String err) {

    }
}







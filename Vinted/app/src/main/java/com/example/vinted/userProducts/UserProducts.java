package com.example.vinted.userProducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.vinted.R;
import com.example.vinted.beans.Producto;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.ListProductsAdapter;
import com.example.vinted.lstProducts.presenter.PresenterListProducts;
import com.example.vinted.lstProducts.view.ListProductActivity;
import com.example.vinted.userProducts.presenter.PresenterUserListProducts;

import java.util.ArrayList;

public class UserProducts extends AppCompatActivity implements ContractUserListProducts.View {

    private PresenterUserListProducts presenter = new PresenterUserListProducts(this);
    RecyclerView recyclerView;
    ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_products);
        myImageView= findViewById(R.id.logOutBtn);

        SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
        String userData = preferences.getString("user_data", null);
        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(UserProducts.this, ListProductActivity.class);
                startActivity(intent);
            }
        });

        presenter.lstProducts(userData);
    }


    @Override
    public void successProducts(ArrayList<Producto> lstProducts) {
        recyclerView = findViewById(R.id.reciclerUser);
        if (recyclerView != null && lstProducts != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            ListProductsAdapter adapter = new ListProductsAdapter(lstProducts);
            recyclerView.setAdapter(adapter);
        }else{
            Log.d("Success products", "successProducts: no ha salido bien");
        }

    }

    @Override
    public void failureProducts(String err) {

    }
}
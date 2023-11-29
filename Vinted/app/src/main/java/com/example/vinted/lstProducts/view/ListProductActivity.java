package com.example.vinted.lstProducts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vinted.R;
import com.example.vinted.addProductos.view.AddActivity;
import com.example.vinted.login.view.LoginActivity;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.ListProductsAdapter;
import com.example.vinted.beans.Producto;
import com.example.vinted.lstProducts.presenter.PresenterListProducts;
import com.example.vinted.userProducts.UserProducts;

import java.util.ArrayList;

public class ListProductActivity extends AppCompatActivity implements ContractListProducts.View{
    private PresenterListProducts presenter = new PresenterListProducts(this);
    RecyclerView recyclerView;
    Button filtroKid;
    Button filtroMujer;
    Button filtroHombre;

    Button addAccess;
    Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        filtroKid = findViewById(R.id.filterKid);
        filtroMujer = findViewById(R.id.filterWoman);
        filtroHombre = findViewById(R.id.filterMan);
        addAccess = findViewById(R.id.addButton);
        logInButton = findViewById(R.id.loginButton);

        addAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListProductActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
                String userData = preferences.getString("user_data", null);

                if(userData == null){
                    Intent intent = new Intent(ListProductActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(ListProductActivity.this, UserProducts.class);
                    startActivity(intent);
                }


            }
        });



        filtroKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.lstProducts("KID");
            };
        });

        filtroMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.lstProducts("WOMAN");
            };
        });

        filtroHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.lstProducts("MAN");
            };
        });

        presenter.lstProducts("");
    }


    @Override
    public void successProducts(ArrayList<Producto> lstProducts) {
        recyclerView = findViewById(R.id.recicler);
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







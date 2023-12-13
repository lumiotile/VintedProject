package com.example.vinted.addProductos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.vinted.R;
import com.example.vinted.addProductos.addContract;
import com.example.vinted.addProductos.presenter.AddProductsPresenter;
import com.example.vinted.beans.Producto;
import com.example.vinted.beans.User;
import com.example.vinted.login.view.LoginActivity;
import com.example.vinted.userProducts.UserProducts;

public class AddActivity extends AppCompatActivity implements addContract.View {


    AddProductsPresenter presenter = new AddProductsPresenter();
    String userData = "";
    EditText nombreProducto;
    EditText precioProducto;
    EditText descripcionProducto;
    Button anyadir;
    Spinner spinnerCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
        userData = preferences.getString("user_data", null);
        innitcompoinents();
    }

    public void innitcompoinents(){
        nombreProducto = findViewById(R.id.nombreProducto);
        precioProducto = findViewById(R.id.precioProducto);
        descripcionProducto = findViewById(R.id.descripcionProducto);
        anyadir = findViewById(R.id.anyadirBtn);
        spinnerCat = findViewById(R.id.spinner);
        anyadir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Producto producto  = new Producto(nombreProducto.getText().toString(),descripcionProducto.getText().toString(),precioProducto.getText().toString());
                producto.setCategoria(null);
                presenter.addin(producto, userData);
            }
        });
    }

    @Override
    public void successAddin(Producto producto) {
        Intent intent = new Intent(AddActivity.this, UserProducts.class);
        startActivity(intent);
    }

    @Override
    public void failureAddin(String err) {

    }
}
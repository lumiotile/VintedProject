package com.example.vinted.addProductos.model;

import android.util.Log;

import com.example.vinted.addProductos.addContract;
import com.example.vinted.beans.Producto;
import com.example.vinted.beans.User;
import com.example.vinted.data_json.JsonProductoData;
import com.example.vinted.data_json.JsonUserData;
import com.example.vinted.utils.ApiService;
import com.example.vinted.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductsModel implements addContract.Model{
    @Override
    public void addinAPI(Producto producto, OnAddinProductsListener addinAPI, String id) {

        //Aqui irán los campos que se envian a la base de datos.

        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Log.d("AddinAPI", "Iniciar proceso de add");
        float precio = Float.parseFloat(producto.getPrecio());
        Call<JsonProductoData> call =   apiService.getAddin("PRODUCTO.ADD", producto.getNombre(), producto.getDescripcion(), precio, null, Integer.parseInt(id));
        call.enqueue(new Callback<JsonProductoData>() {
            @Override
            public void onResponse(Call<JsonProductoData> call, Response<JsonProductoData> response) {
                if (response.isSuccessful()) {
                    JsonProductoData misDatos = response.body();
                    addinAPI.onFinished(producto);
                }else{
                    addinAPI.onFailure("Error a la hora de insertar el producto");
                }
            }

            @Override
            public void onFailure(Call<JsonProductoData> call, Throwable t) {
                Log.d("AddinAPI", "Error");
            }


        });

    }
}

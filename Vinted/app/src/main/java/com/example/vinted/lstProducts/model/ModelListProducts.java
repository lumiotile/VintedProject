package com.example.vinted.lstProducts.model;

import android.util.Log;

import com.example.vinted.data_json.JsonProductoData;
import com.example.vinted.data_json.JsonUserData;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.beans.Producto;
import com.example.vinted.utils.ApiService;
import com.example.vinted.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelListProducts implements ContractListProducts.Model {




    public ArrayList<Producto> listProducts(){
        return null;
    }


    @Override
    public void productsAPI(String filtro, OnProductsListener respuesta) {


        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);

        Call<JsonProductoData> call =   apiService.getDataProductos("PRODUCTO.LIST");
        call.enqueue(new Callback<JsonProductoData>() {
            @Override
            public void onResponse(Call<JsonProductoData> call, Response<JsonProductoData> response) {
                if (response.isSuccessful()) {
                    JsonProductoData misDatos = response.body();
                    if(misDatos!=null && misDatos.getLstUsers().size()>0){
                        respuesta.onFinished(misDatos.getLstUsers());
                    }else{
                        Log.e("Error de datos", "1");
                    }
                }else{
                    Log.e("Response Error", "Not succesful");
                }
            }

            @Override
            public void onFailure(Call<JsonProductoData> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }


        });


        
    }
}

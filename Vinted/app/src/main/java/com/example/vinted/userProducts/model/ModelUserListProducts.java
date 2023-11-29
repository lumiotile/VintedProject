package com.example.vinted.userProducts.model;

import android.util.Log;

import com.example.vinted.beans.Producto;
import com.example.vinted.data_json.JsonProductoData;
import com.example.vinted.userProducts.ContractUserListProducts;
import com.example.vinted.utils.ApiService;
import com.example.vinted.utils.RetrofitCliente;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class ModelUserListProducts implements ContractUserListProducts.Model {




    public ArrayList<Producto> listProducts(){
        return null;
    }


    @Override
    public void productsAPI(String filtro, OnProductsListener respuesta) {

        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);

        Call<JsonProductoData> call =   apiService.getDataProductos("PRODUCTO.LISTUSER", filtro);
        call.enqueue(new Callback<JsonProductoData>() {
            @Override
            public void onResponse(Call<JsonProductoData> call, Response<JsonProductoData> response) {
                if (response != null && response.isSuccessful()) {
                    JsonProductoData misDatos = response.body();
                    if (misDatos != null) {
                        Log.d("Response JSON", new Gson().toJson(misDatos)); // Imprimir el JSON
                        ArrayList<Producto> lstProducts = misDatos.getLstProducts();
                        if (lstProducts != null && !lstProducts.isEmpty()) {
                            Log.d("Product List Size", String.valueOf(lstProducts.size()));
                            for (Producto producto : lstProducts) {
                                Log.d("Product Details", producto.toString());
                            }
                            respuesta.onFinished(lstProducts);
                        } else {
                            Log.e("Error de datos", "La lista de productos está vacía");
                        }
                    } else {
                        Log.e("Error de datos", "Respuesta JSON mal formada o vacía");
                    }
                } else {
                    Log.e("Response Error", "Not successful");
                }
            }




            @Override
            public void onFailure(Call<JsonProductoData> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
                Log.d("Error Back", "Algo mal del back no sé");

                // Log adicional para imprimir más detalles sobre el Throwable
                Log.e("Throwable Details", Log.getStackTraceString(t));

                // Resto del código para manejar la excepción (como en tu bloque original)
                if (call.isExecuted() && !call.isCanceled() && t instanceof HttpException) {
                    HttpException httpException = (HttpException) t;
                    Response<?> response = httpException.response();

                    if (response != null && response.errorBody() != null) {
                        try {
                            Log.e("Response Error Body", response.errorBody().string());
                            Log.e("Response Code", String.valueOf(response.code()));
                            Log.e("Response Message", response.message());

                            Headers headers = response.headers();
                            for (int i = 0; i < headers.size(); i++) {
                                Log.e("Header", headers.name(i) + ": " + headers.value(i));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("Response Error", "La respuesta o el cuerpo de error son nulos");
                    }
                } else {
                    Log.e("Response Error", "No es una instancia de HttpException");
                }
            }




        });



    }
}

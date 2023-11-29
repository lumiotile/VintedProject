package com.example.vinted.addProductos.model;

import android.util.Log;

import com.example.vinted.addProductos.addContract;
import com.example.vinted.beans.Producto;
import com.example.vinted.beans.User;
import com.example.vinted.data_json.JsonUserData;
import com.example.vinted.utils.ApiService;
import com.example.vinted.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductsModel implements addContract.Model{
    @Override
    public void addinAPI(Producto producto, OnAddinProductsListener addinAPI) {

        //Aqui irán los campos que se envian a la base de datos.


        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Log.d("AddinAPI", "Iniciar proceso de add");
        Call<JsonUserData> call =   apiService.getDataProducto("PRODUCTO.ADD");

        call.enqueue(new Callback<JsonUserData>() {
            @Override
            public void onResponse(Call<JsonUserData> call, Response<JsonUserData> response) {
                if (response.isSuccessful()) {
                    JsonUserData misDatos = response.body();
                    if(misDatos!=null && misDatos.getLstUsers().size()>0){
                        Log.d("LoginAPI", "Datos recibidos correctamente");
                        Log.e("Datos", String.valueOf(misDatos.getLstUsers().get(0).getId()));

                        respuesta.onFinished(misDatos.getLstUsers().get(0));
                    }else{
                        Log.e("LoginAPI", "Error en los datos recibidos");
                        Log.e("Error de datos", "1");
                    }
                }else{
                    Log.e("LoginAPI", "Error en la respuesta del servidor");
                    Log.e("Response Error", "Not succesful");
                }
            }

            @Override
            public void onFailure(Call<JsonUserData> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });

    }
}

package com.example.vinted.login.model;

import android.util.Log;

import com.example.vinted.beans.User;
import com.example.vinted.data_json.JsonUserData;
import com.example.vinted.login.ContractLogin;
import com.example.vinted.login.presenter.LoginPresenter;
import com.example.vinted.utils.ApiService;
import com.example.vinted.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelLogin implements ContractLogin.Model {

    private LoginPresenter presenter;
    public ModelLogin(LoginPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(User user, OnProductsListener respuesta) {

        //Aqui irá la solicitud a base de datos.
        String username = user.getUsername();
        String pass = user.getToken();

        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Log.d("LoginAPI", "Iniciar proceso de login");
        Log.d("Username", username);
        Log.d("PASS", pass);
        Call<JsonUserData> call =   apiService.getDataUser("USUARIO.LOGIN", username, pass);

        call.enqueue(new Callback<JsonUserData>() {
            @Override
            public void onResponse(Call<JsonUserData> call, Response<JsonUserData> response) {
                if (response.isSuccessful()) {
                                JsonUserData misDatos = response.body();
                                if(misDatos!=null && misDatos.getLstUsers().size()>0){
                                    Log.d("LoginAPI", "Datos recibidos correctamente");
                                    Log.e("Datos", misDatos.getLstUsers().get(0).getUsername());

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


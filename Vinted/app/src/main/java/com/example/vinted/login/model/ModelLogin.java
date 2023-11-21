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

        /*if(username.equals("test") && pass.equals("test")){
            respuesta.onFinished(user);
        }else{
            respuesta.onFailure("Usuario o contraseña incorrectos");
        }*/

        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);

        Call<JsonUserData> call =   apiService.getDataUser("USUARIO.LOGIN", "a", "1234");
        call.enqueue(new Callback<JsonUserData>() {
            @Override
            public void onResponse(Call<JsonUserData> call, Response<JsonUserData> response) {
                if (response.isSuccessful()) {
                                JsonUserData misDatos = response.body();
                                if(misDatos!=null && misDatos.getLstUsers().size()>0){
                                    Log.e("Datos", misDatos.getLstUsers().get(0).getUsername());
                                    respuesta.onFinished(misDatos.getLstUsers().get(0));
                                }else{
                                    Log.e("Error de datos", "1");
                                }
                }else{
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


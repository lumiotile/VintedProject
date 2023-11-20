package com.example.vinted.login.model;

import com.example.vinted.login.ContractLogin;
import com.example.vinted.login.bean.User;
import com.example.vinted.login.presenter.LoginPresenter;

public class ModelLogin implements ContractLogin.Model {

    private LoginPresenter presenter;
    public ModelLogin(LoginPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(User user, OnProductsListener respuesta) {

        //Aqui irá la solicitud a base de datos.
        String username = user.getUsername();
        String pass = user.getPass();
        if(username.equals("test") && pass.equals("test")){
            respuesta.onFinished(user);
        }else{
            respuesta.onFailure("Usuario o contraseña incorrectos");
        }
    }
}

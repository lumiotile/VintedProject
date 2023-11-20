package com.example.vinted.login.presenter;

import com.example.vinted.login.ContractLogin;
import com.example.vinted.login.bean.User;
import com.example.vinted.login.model.ModelLogin;

public class LoginPresenter implements ContractLogin.Presenter, ContractLogin.Model.OnProductsListener {

    private ContractLogin.View vista;
    private ModelLogin model;

    public LoginPresenter(ContractLogin.View vista) {
        this.vista = vista;
        model = new ModelLogin(this);
    }

    public void onFinished(User user) {
        vista.successLogin(user);
    }

    @Override
    public void onFailure(String err) {
        vista.failureLogin("Error");
    }

    @Override
    public void login(User user) {
        model.loginAPI(user, this);
    }




}

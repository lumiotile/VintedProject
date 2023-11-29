package com.example.vinted.addProductos.presenter;

import com.example.vinted.addProductos.addContract;
import com.example.vinted.beans.Producto;
import com.example.vinted.beans.User;

public class AddProductsPresenter implements addContract.Presenter, addContract.Model.OnAddinProductsListener{
    @Override
    public void onFinished(Producto producto) {

    }

    @Override
    public void onFailure(String err) {

    }

    @Override
    public void addin(Producto producto) {

    }
}

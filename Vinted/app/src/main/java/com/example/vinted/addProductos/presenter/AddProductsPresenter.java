package com.example.vinted.addProductos.presenter;

import com.example.vinted.addProductos.addContract;
import com.example.vinted.addProductos.model.AddProductsModel;
import com.example.vinted.beans.Producto;
import com.example.vinted.beans.User;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.model.ModelListProducts;

public class AddProductsPresenter implements addContract.Presenter, addContract.Model.OnAddinProductsListener{

    private addContract.View vista;
    private AddProductsModel model;
    @Override
    public void onFinished(Producto producto) {

    }

    @Override
    public void onFailure(String err) {

    }

    @Override
    public void addin(Producto producto, String id) {
        model.addinAPI(producto, this, id);
    }

}

package com.example.vinted.userProducts.presenter;

import com.example.vinted.beans.Producto;
import com.example.vinted.userProducts.ContractUserListProducts;
import com.example.vinted.userProducts.model.ModelUserListProducts;

import java.util.ArrayList;

public class
PresenterUserListProducts implements ContractUserListProducts.Presenter, ContractUserListProducts.Model.OnProductsListener {
    private ContractUserListProducts.View vista;
    private ModelUserListProducts lstModel;

    public PresenterUserListProducts(ContractUserListProducts.View vista){
        this.vista = vista;
        lstModel = new ModelUserListProducts();
    }


    @Override
    public void lstProducts(String filtro) {

        lstModel.productsAPI(filtro, this);
    }

    @Override
    public void onFinished(ArrayList<Producto> lstPelicula) {
        vista.successProducts(lstPelicula);
    }

    @Override
    public void onFailure(String err) {

    }
}

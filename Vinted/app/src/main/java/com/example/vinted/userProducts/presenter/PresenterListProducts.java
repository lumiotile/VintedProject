package com.example.vinted.userProducts.presenter;

import com.example.vinted.beans.Producto;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.model.ModelListProducts;

import java.util.ArrayList;

public class PresenterListProducts implements ContractListProducts.Presenter, ContractListProducts.Model.OnProductsListener {
    private ContractListProducts.View vista;
    private ModelListProducts lstModel;

    public PresenterListProducts(ContractListProducts.View vista){
        this.vista = vista;
        lstModel = new ModelListProducts();
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

package com.example.vinted.lstProducts.presenter;

import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.model.ModelListProducts;

import java.util.ArrayList;

public class PresenterListProducts implements ContractListProducts.Presenter {
    private ContractListProducts.View vista;
    private ModelListProducts lstModel;

    public PresenterListProducts(ContractListProducts.View vista){
        this.vista = vista;
        lstModel = new ModelListProducts(this);
    }

    @Override
    public void productsAPI(String filtro, OnProductsListener respuestaMovies) {

    }


    @Override
    public void lstMovies(String filtro) {
        lstMoviesModel.moviesAPI("", this);
    }

    @Override
    public void onFinished(ArrayList<Pelicula> lstPelicula) {
        vista.successMovies(lstPelicula);
    }

    @Override
    public void onFailure(String err) {

    }


}

package com.example.vinted.lstProducts.model;

import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.bean.Producto;

import java.util.ArrayList;

public class ModelListProducts implements ContractListProducts.Model {



    public ArrayList<Producto> listProducts(){
        return null;
    }

    @Override
    public void successProducts(ArrayList<Producto> lstPelicula) {

    }

    @Override
    public void failureProducts(String err) {

    }


}

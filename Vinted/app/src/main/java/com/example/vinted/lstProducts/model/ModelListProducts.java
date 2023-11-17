package com.example.vinted.lstProducts.model;

import com.example.vinted.conn.Connector;
import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.bean.Producto;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ModelListProducts implements ContractListProducts.Model {


    Connector conn = new Connector();

    public ArrayList<Producto> listProducts(){
        return null;
    }


    @Override
    public ResultSet productsAPI(String filtro, OnProductsListener respuestaMovies) {
        String SQL = "";
        return conn.executeQuery(SQL);
    }
}

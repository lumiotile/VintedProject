package com.example.vinted.lstProducts.model;

import com.example.vinted.lstProducts.ContractListProducts;
import com.example.vinted.lstProducts.bean.Producto;

import java.util.ArrayList;

public class ModelListProducts implements ContractListProducts.Model {




    public ArrayList<Producto> listProducts(){
        return null;
    }


    @Override
    public void productsAPI(String filtro, OnProductsListener respuestaMovies) {
        //String SQL = "";
        //return conn.executeQuery(SQL);
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("1", "Producto1", "Descripción1", 20));
        listaProductos.add(new Producto("2", "Producto2", "Descripción2", 15));
        listaProductos.add(new Producto("3", "Producto3", "Descripción3", 30));

        respuestaMovies.onFinished(listaProductos);
    }
}

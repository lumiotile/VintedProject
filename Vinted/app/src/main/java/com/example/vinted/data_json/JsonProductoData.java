package com.example.vinted.data_json;

import com.example.vinted.beans.Producto;

import java.util.ArrayList;

public class JsonProductoData {
    private String message;
    private ArrayList<Producto> lstProducts = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    // Cambia el nombre del método para que coincida con el uso en tu modelo de respuesta
    public ArrayList<Producto> getLstProducts() {
        return lstProducts;
    }

    // No olvides actualizar también el nombre del método de configuración si lo usas
    public void setLstProducts(ArrayList<Producto> lstProducts) {
        this.lstProducts = lstProducts;
    }
}

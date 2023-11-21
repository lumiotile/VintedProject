package com.example.vinted.data_json;

import com.example.vinted.beans.Producto;

import java.util.ArrayList;

public class JsonProductoData {
    private String message;
    private ArrayList<Producto> lstUsers;


    public String getMessage() {
        return message;
    }
    public ArrayList<Producto> getLstUsers() {
        return lstUsers;
    }
    public void setLstUsers(ArrayList<Producto> lstUsers) {
        this.lstUsers = lstUsers;
    }
}


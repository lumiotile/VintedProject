package com.example.vinted.addProductos;

import com.example.vinted.beans.Producto;
import com.example.vinted.beans.User;
import com.example.vinted.login.ContractLogin;

public interface addContract {
    public interface View{
        public void successAddin(Producto producto);
        void failureAddin(String err);
    }
    public interface Model  {
        void addinAPI(Producto producto, addContract.Model.OnAddinProductsListener addinAPI, String id);
        interface OnAddinProductsListener{
            void onFinished(Producto producto);
            void onFailure(String err);
        }
    }
    public interface Presenter{
        void addin(Producto producto, String id);
    }
}



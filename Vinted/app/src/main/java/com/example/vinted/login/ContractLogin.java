package com.example.vinted.login;

import com.example.vinted.lstProducts.bean.Producto;
import com.example.vinted.login.bean.User;
import java.util.ArrayList;

public interface ContractLogin {
    
    public interface View{
        public void successLogin(User user);
        void failureLogin(String err);
    }
    public interface Model  {
        void loginAPI(User user, OnProductsListener loginAPI);
        interface OnProductsListener{
            void onFinished(User user);
            void onFailure(String err);
        }
    }
    public interface Presenter{
        void login(User user);
    }
}

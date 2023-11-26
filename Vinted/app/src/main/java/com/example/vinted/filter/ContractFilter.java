package com.example.vinted.filter;

import com.example.vinted.beans.User;
import com.example.vinted.login.ContractLogin;

public interface ContractFilter {

    public interface View{
        public void success();
        void failure();
    }
    public interface Model  {
        void filterAPI(String filter, ContractLogin.Model.OnProductsListener listener);
        interface OnProductsListener{
            void onFinished();
            void onFailure();
        }
    }
    public interface Presenter{
        void filter();
    }
}

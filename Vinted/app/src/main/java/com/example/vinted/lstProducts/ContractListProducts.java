package com.example.vinted.lstProducts;

import com.example.vinted.lstProducts.bean.Producto;

import java.util.ArrayList;

public interface ContractListProducts {
    
    public interface View{
        void lstProducts(String filtro);
    }
    public interface Presenter  {
        void productsAPI(String filtro,
                         OnProductsListener respuestaMovies);
        interface OnProductsListener{
            void onFinished(ArrayList<Producto> lstPelicula);
            void onFailure(String err);
        }
    }
    public interface Model{
        public void successProducts(ArrayList<Producto> lstPelicula);
        void failureProducts(String err);
    }
}

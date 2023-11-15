package com.example.vinted.lstProducts;

import com.example.vinted.lstProducts.bean.Producto;

import java.util.ArrayList;

public interface ContractListProducts {
    
    public interface View{
        public void successProducts(ArrayList<Producto> lstPelicula);
        void failureProducts(String err);
    }
    public interface Model  {
        void productsAPI(String filtro,
                         OnProductsListener respuestaMovies);
        interface OnProductsListener{
            void onFinished(ArrayList<Producto> lstPelicula);
            void onFailure(String err);
        }
    }
    public interface Presenter{
        void productsAPI(String filtro, Model.OnProductsListener respuestaMovies);

        void lstProducts(String filtro);
    }
}

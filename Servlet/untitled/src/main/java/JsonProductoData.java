

import java.util.ArrayList;

public class JsonProductoData {
    private String message;
    private ArrayList<Producto> lstProducts;


    public String getMessage() {
        return message;
    }
    public ArrayList<Producto> getLstUsers() {
        return lstProducts;
    }
    public void setLstProducts(ArrayList<Producto> lstProducts) {
        this.lstProducts = lstProducts;
    }
}


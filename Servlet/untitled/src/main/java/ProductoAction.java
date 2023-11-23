/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;


/**
 *
 * @author S2-PC104
 */
public class ProductoAction {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String jsonRespuesta = "";
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1]) {
            case "LIST":
                jsonRespuesta = listAll();
                break;
        }
        return jsonRespuesta;
    }
    

    public String listAll(){
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> productos = productoDAO.findAll();
        Gson gson = new Gson();
        String json = "{\n" +
                "    \"message\": \"Login incorrecto. \",\n" +
                "    \"lstUsers\":";

             json += gson.toJson(productos);

        return json;
    }



}

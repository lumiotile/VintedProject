/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.mysql.cj.log.Log;


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
        System.out.println("Entrando en el metodo list all");
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> productos = productoDAO.findAll();
        System.out.println("Se ha ejecutado el find all" + Producto.toJson(productos));
        String json = "{\n" +
                "    \"message\": \"Listado de productos correcto. \",\n" +
                "    \"lstProducts\": [\n";

        int size = productos.size();
        for (int i = 0; i < size; i++) {
            Producto producto = productos.get(i);
            json += "        {\n" +
                    "            \"nombre\":\"" + producto.getNombre() + "\",\n" +
                    "            \"descripcion\": \"" + producto.getDescripcion() + "\",\n" +
                    "            \"precio\": \"" + producto.getPrecio() + "\" \n" +
                    "        }";

            // Agregar una coma solo si no es el último elemento
            if (i < size - 1) {
                json += ",";
            }

            json += "\n";
        }

        json += "    ]\n" +
                "}";
        System.out.println(json);


        return json;
    }



}

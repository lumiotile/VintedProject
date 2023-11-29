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
                jsonRespuesta = listAll(request, response);
                break;
            case "LISTUSER":
                jsonRespuesta = listAllUser(request, response);
                break;
        }
        return jsonRespuesta;
    }
    

    public String listAll(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Entrando en el metodo list all");
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> productos = productoDAO.findAll("SELECT  *  FROM productos");
        String filtro = request.getParameter("FILTRO");

        System.out.println(filtro);

        switch (filtro){
            case "KID":
                productos = productoDAO.findAll("SELECT  *  FROM productos WHERE categoria ='KID'");
                break;
            case "WOMAN":
                productos = productoDAO.findAll("SELECT  *  FROM productos WHERE categoria ='WOMAN'");
                break;
            case "MAN":
                productos = productoDAO.findAll("SELECT  *  FROM productos WHERE categoria ='MAN'");
                break;
            case "":
                productos = productoDAO.findAll("SELECT  *  FROM productos");
                break;
        }

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

    public String listAllUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Entrando en el metodo list all");
        ProductoDAO productoDAO = new ProductoDAO();

        String filtro = request.getParameter("FILTRO");

        System.out.println(filtro);

        ArrayList<Producto> productos = productoDAO.findAll("SELECT  *  FROM productos WHERE id_cliente='"+filtro+"'");

        System.out.println("SELECT  *  FROM productos WHERE id_cliente='"+filtro+"'");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author S2-PC104
 */
public class ProductoDAO extends Producto{
        private static final String SQL_INSERT = "INSERT INTO USUARIOS (EMAIL, NOMBRE_USUARIO, CONTRASENA, PHONE) VALUES ";
                                                //INSERT INTO APP.USUARIO (ID, EMAIL, PASSWORD) VALUES (1, 'A', '1234')
                                                // INSERT INTO APP.USUARIO (EMAIL, PASSWORD) VALUES ('A', 'A')
    private static final String SQL_FIND_ALL = "SELECT  *  FROM productos";

    private MotorSQL motorSql;

    public ProductoDAO() {
        this.motorSql = new MotorSQL();
    }



    public ArrayList<Producto> findAll() {

        ArrayList<Producto> productos = new ArrayList<>();
        this.motorSql.connect();
        String sql = SQL_FIND_ALL;

        System.out.println("SQL-> " + sql);
        ResultSet rs = this.motorSql.executeQuery(sql);
        if(rs != null){
            System.out.println("No ha encontrado nada");
        }
        try {
            while (rs.next()) {// TRANSFOMAR LA COLECCIÓN DEBASE DE DATOS A UN ARRAYLIST
                Producto producto = new Producto();

                // hay que ordenarlo en base a como esten los campos en la base de datos

                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));

                productos.add(producto);

            }

            System.out.println("Productos guardados");

        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            motorSql.disconnect();
        }
        return productos;
    }

}

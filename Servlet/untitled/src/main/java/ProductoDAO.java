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



    public ArrayList<Producto> findAll(String sql) {

        ArrayList<Producto> productos = new ArrayList<>();
        this.motorSql.connect();

        System.out.println("SQL-> " + sql);
        ResultSet rs = this.motorSql.executeQuery(sql);
        if (rs == null) {
            System.out.println("Error al ejecutar la consulta");
        } else {
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
            } finally {
                motorSql.disconnect();
            }
        }
        return productos;
    }

    public boolean insertData(String sql) {
        boolean success = false;
        this.motorSql.connect();

        try {
            System.out.println("SQL-> " + sql);

            int rowsAffected = this.motorSql.execute(sql);

            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa. Filas afectadas: " + rowsAffected);
                success = true;
            } else {
                System.out.println("Error al ejecutar la inserción. No se realizaron cambios en la base de datos.");
            }

        } finally {
            motorSql.disconnect();
        }

        return success;
    }




}

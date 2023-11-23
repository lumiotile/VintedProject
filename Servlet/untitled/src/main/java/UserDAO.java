/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author S2-PC104
 */
public class UserDAO extends Usuario{
        private static final String SQL_INSERT = "INSERT INTO USUARIOS (EMAIL, NOMBRE_USUARIO, CONTRASENA, PHONE) VALUES ";
                                                //INSERT INTO APP.USUARIO (ID, EMAIL, PASSWORD) VALUES (1, 'A', '1234')
                                                // INSERT INTO APP.USUARIO (EMAIL, PASSWORD) VALUES ('A', 'A')
    private static final String SQL_FIND_ALL = "SELECT  *  FROM clientes WHERE ";

    private MotorSQL motorSql;

    private Gson gson = new Gson();

    public UserDAO() {
        this.motorSql = new MotorSQL();
    }

    /*public int add(Usuario entidad) {
        this.motorSql.connect();
        
        /*System.out.println("SQL-> " + sql);
        int resp = this.motorSql.execute(sql);
        this.motorSql.disconnect();
        return resp;

    }*/



    public String findAll(Usuario bean) {
        String bool = "";
        motorSql.connect();
        UserDAO userDAO = new UserDAO();
        Usuario usuario = new Usuario();

        String sql = SQL_FIND_ALL
            + "username="+"'" +bean.getNombre()+"'"  + " AND password like " + "'%" +bean.getPassword()+"%'";

        System.out.println("SQL-> " + sql);
        ResultSet rs = this.motorSql.executeQuery(sql);
        try {
            if (rs.next()){ // la exclamacion hace que te devuelva un booleano en caso de que esté vacio o no

                usuario.setNombre(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                bool = gson.toJson(usuario);

            }else{
                bool = "";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            motorSql.disconnect();
        }
        return bool;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Usuario usuario = new Usuario();
        usuario.setNombre("admin");
        usuario.setPassword("admin");
        System.out.println(userDAO.findAll(usuario));
    }

}

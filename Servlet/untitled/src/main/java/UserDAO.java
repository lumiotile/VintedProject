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
public class UserDAO extends Usuario{
        private static final String SQL_INSERT = "INSERT INTO USUARIOS (EMAIL, NOMBRE_USUARIO, CONTRASENA, PHONE) VALUES ";
                                                //INSERT INTO APP.USUARIO (ID, EMAIL, PASSWORD) VALUES (1, 'A', '1234')
                                                // INSERT INTO APP.USUARIO (EMAIL, PASSWORD) VALUES ('A', 'A')
    private static final String SQL_FIND_ALL = "SELECT  *  FROM usuarios WHERE ";

    private MotorSQL motorSql;

    public UserDAO() {
        this.motorSql = new MotorSQL();
    }

    public int add(Usuario entidad) {
        this.motorSql.connect();
        String sql = SQL_INSERT
                + "('" + entidad.getEmail() + " ' , "
                + " ' " + entidad.getNombre() + " ' , "
                + " ' " + entidad.getPassword() + " ' , "
                + " ' " + entidad.getPhone() + " ' )";
        
        System.out.println("SQL-> " + sql);
        int resp = this.motorSql.execute(sql);
        this.motorSql.disconnect();
        return resp;

    }



    public boolean findAll(Usuario bean) {
        boolean bool = true;
         this.motorSql.connect();
        String sql = SQL_FIND_ALL
            + "EMAIL= " +"'" +bean.getEmail()+"'"  + " AND CONTRASENA like " + "'%" +bean.getPassword()+"%'";

        System.out.println("SQL-> " + sql);
        ResultSet rs = this.motorSql.executeQuery(sql);
        try {
            if (!rs.next()){ // la exclamacion hace que te devuelva un booleano en caso de que esté vacio o no
                bool= false;
            }else{
                bool= true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            motorSql.disconnect();
        }
        return bool;
    }

}

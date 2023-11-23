import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MotorSQL {

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";


    private static final String USER = "admin";
    private static final String PASS = "12341234";

    private static final String URL = "jdbc:mysql://database-1.c54eslr2posn.us-east-1.rds.amazonaws.com:3306/Vinted?user=admin&password=12341234";
    public void connect() {
        try {

            Class.forName(CONTROLADOR);

            conn = DriverManager.getConnection(URL);
            System.out.println("Holaa");

            st = conn.createStatement();
        //} catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public int execute(String sql) {
        int resp = 0;
        try {
            resp = st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    public ResultSet executeQuery(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S2-PC104
 */
public class Usuario {

    public static String toJSon(Usuario usuario) {
        String json = "{";
        json += "\"id\":" + usuario.getId() + ",";
        json += "\"email\":\"" + usuario.getEmail() + "\",";
        json += "\"password\":\"" + usuario.getPassword() + "\"";
        json += "}";
        return json;
    }


     private int id;
    private String email;
    private String password;
    private String nombre;
    private String phone;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Usuario() {
    }

    public Usuario(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }
    
}
    


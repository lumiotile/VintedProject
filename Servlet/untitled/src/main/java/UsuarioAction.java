/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author S2-PC104
 */
public class UsuarioAction {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String jsonRespuesta = "";
        String action = request.getParameter("ACTION");
        action = "USUARIO.LOGIN";
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1]) {
            case "REGISTER":
                jsonRespuesta = register(request, response);
                break;
            case "LOGIN":
                jsonRespuesta = login(request, response);
                break;
        }
        return jsonRespuesta;
    }
    

    private String register(HttpServletRequest request,
            HttpServletResponse response) {
        String email = request.getParameter("EMAIL");
        String pass = request.getParameter("PASSWORD");
        String nombre = request.getParameter("NOMBRE_USUARIO");
        String telefono = request.getParameter("TLF");
        
        Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setPassword(pass);
            usuario.setNombre(nombre);
            usuario.setPhone(telefono);
        UserDAO usuarioDAO = new UserDAO();
        int numFilasModificadas = usuarioDAO.add(usuario);
        String respJSON = "";
        if(numFilasModificadas>0){
            Usuario.toJSon(usuario);
        }else{
            usuario.setEmail(null);
            usuario.setPassword(null);
        }
        // Usuario.toArrayJSon(peliculas);
        return Usuario.toJSon(usuario);
    }

    
    private String login(HttpServletRequest request,
            HttpServletResponse response) {
        
        String email = request.getParameter("EMAIL");
        String pass = request.getParameter("PASSWORD");
        email = "a";
        pass = "1234";
        String msg = "";
        
    
            Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setPassword(pass);
            // UserDAO usuarioDAO = new UserDAO();
             // boolean usuariosEncontrados = usuarioDAO.findAll(usuario);
            boolean usuariosEncontrados  = true;
            if( usuariosEncontrados == true){
                msg = "{\n" +
                        "    \"message\": \"Login correcto. \",\n" +
                        "    \"lstUsers\": [\n" +
                        "        {\n" +
                        "            \"username\":\"" +  usuario.getEmail() + "\",\n" +
                        "            \"token\": \"" +  usuario.getPassword() + "\" \n" +
                        "        }" +
                        "    ]\n" +
                        "}";
                // msg = "true";
            }else{
                msg = "{\n" +
                        "    \"message\": \"Login incorrecto. \",\n" +
                        "    \"lstUsers\": [\n" +
                        "        {\n" +
                        "            \"username\":" +  usuario.getEmail() + ",\n" +
                        "            \"token\": " +  usuario.getPassword() + "\n" +
                        "        }" +
                        "    ]\n" +
                        "}";
            };
            
        
       return msg;
    }
    
    
}

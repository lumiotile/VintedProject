
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MyServlet")
public class MyServlet  extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            // Procesa alguna lógica aquí
            response.setContentType("application/json");
                                                                    //response.setContentType("text/plain;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String action = request.getParameter("ACTION");
            action = "USUARIO.LOGIN";
            String[] arrayAction = action.split("\\.");

            switch (arrayAction[0]) {
                case "USUARIO":
                    out.print(new UsuarioAction().execute(request, response));
                    // USUARIO.LOGIN
                    break;
            }


            out.close();
        }

    /*public static String convertUsersToJSONString(List<User> users) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"username\": \"").append(user.getUsername()).append("\", ");
            jsonBuilder.append("\"token\": \"").append(user.getToken()).append("\"");
            jsonBuilder.append("}");

            // Si no es el último elemento, añade una coma
            if (i < users.size() - 1) {
                jsonBuilder.append(", ");
            }
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }*/
    /*
    *  String action = request.getParameter("ACTION");
            //String id= request.getParameter("id");
            PrintWriter out = response.getWriter();
            //out.print(message);a
            String jsonResponse = "{\"message\": \"¡Hola desde el Servlet!_"+ action + "\"}";

            String jsonResponseObject= "{\n" +
                    "    \"message\": \"Este es un mensaje de ejemplo\",\n" +
                    "    \"lstUsers\": [\n" +
                    "        {\n" +
                    "            \"username\": \"username1\",\n" +
                    "            \"token\": \"token1\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"username\": \"username2\",\n" +
                    "            \"token\": \"token2\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"username\": \"username3\",\n" +
                    "            \"token\": \"token3\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            User user1 = new User("username1", "token1");
            User user2 = new User("username2", "token2");

            List<User> userList = new ArrayList<>();
            userList.add(user1);
            userList.add(user2);

            String peliculas = "{\n" +
                    "    \"message\": \"Este es un mensaje de ejemplo\",\n" +
                    "    \"lstPeliculas\": [\n" +
                    "        {\n" +
                    "            \"id\": 1,\n" +
                    "            \"titulo\": \"Pelicula 1\",\n" +
                    "            \"descripcion\": \"Descripción de la Pelicula 1\",\n" +
                    "            \"director\": \"Director 1\",\n" +
                    "            \"anyo\": 2022\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"id\": 2,\n" +
                    "            \"titulo\": \"Pelicula 2\",\n" +
                    "            \"descripcion\": \"Descripción de la Pelicula 2\",\n" +
                    "            \"director\": \"Director 2\",\n" +
                    "            \"anyo\": 2023\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"id\": 3,\n" +
                    "            \"titulo\": \"Pelicula 3\",\n" +
                    "            \"descripcion\": \"Descripción de la Pelicula 3\",\n" +
                    "            \"director\": \"Director 3\",\n" +
                    "            \"anyo\": 2021\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            //out.print(convertUsersToJSONString(userList));
            // out.print(jsonResponseObject);

            // Escribir el JSON en el PrintWriter
            //out.print(jsonResponse);
            /*request.setAttribute("message", message);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

            out.print(peliculas);*/

    }



package web;

import datos.UsuarioDaoJDBC;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author steven
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Usuario> Usuarios = new UsuarioDaoJDBC().listar();
            System.out.print("Usuarios = "+Usuarios);
            request.setAttribute("Usuarios",Usuarios );
            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);    
    }
}

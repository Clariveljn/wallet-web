package cl.alkewallet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.alkewallet.model.Usuario;
import cl.alkewallet.service.UsuarioService;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(password);

        UsuarioService usuarioService = new UsuarioService();
        boolean registrado = usuarioService.registrarUsuario(usuario);

        if (registrado) {
            response.sendRedirect("pages/login.jsp");
        } else {
            request.setAttribute("mensaje", "Error al registrar el usuario.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro.jsp");
            dispatcher.forward(request, response);
        }
    }
}

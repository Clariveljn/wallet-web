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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UsuarioService usuarioService = new UsuarioService();
		Usuario usuario = usuarioService.autenticarUsuario(email, password);

		if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("pages/menu.jsp");
		} else {
			request.setAttribute("mensaje", "Email o contraseña incorrectos.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}

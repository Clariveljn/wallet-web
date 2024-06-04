package cl.alkewallet.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Usuario;
import cl.alkewallet.service.CuentaService;

@WebServlet("/CuentasServlet")
public class CuentaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuentaService cuentaService;

    public CuentaServlet() {
        cuentaService = new CuentaService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Mostrar las cuentas del usuario
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        List<Cuenta> cuentas = cuentaService.obtenerCuentasPorIdUsuario(usuario.getIdUsuario());
        request.setAttribute("cuentas", cuentas);
        request.setAttribute("usuario", usuario); 
        request.getRequestDispatcher("pages/misCuentas.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Agregar una nueva cuenta
        String action = request.getParameter("action");
        if (action.equals("agregarCuenta")) {
            String titular = request.getParameter("titular");
            String numeroCuenta = request.getParameter("numeroCuenta");
            double saldo = 0.0; 
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            Cuenta cuenta = new Cuenta(usuario.getIdUsuario(), numeroCuenta, saldo, titular, new Date());
            int resultado = cuentaService.agregarCuenta(cuenta);
            if (resultado > 0) {
                response.sendRedirect("CuentasServlet");
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }
}
package cl.alkewallet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.alkewallet.dao.CuentaDao;
import cl.alkewallet.model.Cuenta;
import cl.alkewallet.service.CuentaService;

@WebServlet("/RetirarServlet")
public class RetirarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
        double montoRetirar = Double.parseDouble(request.getParameter("montoRetirar"));

        CuentaService cuentaService = new CuentaService();
        try {
            boolean retiroExitoso = cuentaService.retirar(idCuenta, montoRetirar);

            if (retiroExitoso) {
                // Obtener la información de la cuenta para mostrarla en la página de éxito
                CuentaDao cuentaDao = new CuentaDao();
                Cuenta cuenta = cuentaDao.obtenerCuentaPorIdCuenta(idCuenta);
                String titular = cuenta.getTitular();
                String numeroCuenta = cuenta.getNumeroCuenta();
                double saldo = cuenta.getSaldo();

                // Guardar la información en el request para pasarla a la página de éxito
                request.setAttribute("titular", titular);
                request.setAttribute("numeroCuenta", numeroCuenta);
                request.setAttribute("saldo", saldo);

                // Redirigir al usuario a la página de éxito
                request.getRequestDispatcher("/pages/exitoRetiro.jsp").forward(request, response);
            }
        } catch (Exception e) {
            if (e.getMessage().contains("Saldo insuficiente")) {
                request.setAttribute("mensaje", "Error al realizar el retiro: Saldo insuficiente");
            } else {
                request.setAttribute("mensaje", "Error al realizar el retiro");
            }
            request.getRequestDispatcher("/pages/retirar.jsp").forward(request, response);
        }
    }
  
}


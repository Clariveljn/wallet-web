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


@WebServlet("/DepositarServlet")
public class DepositarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
	    double montoDepositar = Double.parseDouble(request.getParameter("montoDepositar"));
	    
	    CuentaService cuentaService = new CuentaService();
	    boolean depositoExitoso = cuentaService.depositar(idCuenta, montoDepositar);
	    
	    if (depositoExitoso) {
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
	        request.getRequestDispatcher("/pages/exito.jsp").forward(request, response);
	    } else {
	        request.setAttribute("mensaje", "Error al realizar el depósito");
	        request.getRequestDispatcher("/pages/depositar.jsp").forward(request, response);
	    }
	}
}





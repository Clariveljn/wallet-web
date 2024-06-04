<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cl.alkewallet.model.Cuenta"%>
<%@ page import="cl.alkewallet.model.Usuario"%>
<%@ page import="cl.alkewallet.service.CuentaService"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <title>Mis Cuentas</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid bg-dark p-2">
            <a href="${pageContext.request.contextPath}/pages/index.jsp">
                <img src="${pageContext.request.contextPath}/img/logo-navbar.png" alt="logo Alke-Wallet"
                    class="img-fluid logo-navbar" />
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav fs-5 ms-auto">
                    <a class="nav-link me-4" href="${pageContext.request.contextPath}/pages/index.jsp">Salir</a>
                </div>
            </div>
        </div>
    </nav>

    <div class="flex-grow-1">

        <div class="card p-3 mx-auto mt-4 text-center">
        <h2 class="text-center">Agregar cuenta</h2>
            <form class= "text-center" action="${pageContext.request.contextPath}/CuentasServlet" method="post">
                <input type="hidden" name="action" value="agregarCuenta">
                <label for="titular">Titular:</label> <br>
                <input type="text" id="titular" name="titular" value="${usuario.nombre} ${usuario.apellido}" readonly><br><br>
                <label for="numeroCuenta">Número de cuenta:</label><br>
                <input type="text" id="numeroCuenta" name="numeroCuenta" required><br><br>
                <input type="submit" class="btn btn-info btn-lg p-2 mb-2 d-block mx-auto" value="Agregar cuenta">
            </form>
        </div>

        <%
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        List<Cuenta> cuentas = new CuentaService().obtenerCuentasPorIdUsuario(usuario.getIdUsuario());
        request.setAttribute("cuentas", cuentas);
        %>

        <%
        if (cuentas != null) {
        %>
        <table class="table text-center table-responsive mx-auto" style="width: 90%;">
    <% if (!cuentas.isEmpty()) { %>
    
    <h2 class="table text-center m-3">Mis cuentas</h2>
    
    <thead class="table-dark">
        <tr>
            <th>Número de Cuenta</th>
            <th>Saldo</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody >
        <% for (Cuenta cuenta : cuentas) { %>
        <tr>
            <td><%= cuenta.getNumeroCuenta() %></td>
            <td><%= cuenta.getSaldo() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/pages/depositar.jsp?idCuenta=<%= cuenta.getIdCuenta() %>"
                    class="btn btn-info">Depositar</a>
                <a href="${pageContext.request.contextPath}/pages/retirar.jsp?idCuenta=<%= cuenta.getIdCuenta() %>"
                    class="btn btn-info">Retirar</a>
                <a href="${pageContext.request.contextPath}/pages/transferir.jsp?idCuenta=<%= cuenta.getIdCuenta() %>"
                    class="btn btn-info">Transferir</a>
            </td>
        </tr>
        <% } %>
    </tbody>
    <% } %>
</table>
        

        <%
        } else {
        %>
        <p>No se encontraron cuentas.</p>
        <%
        }
        %>

  </div>
    <footer class="footer bg-dark text-white py-3 text-center mt-4"">
        <p class="mb-1">Contacto: info@alkewallet.com</p>
        <p>
            <a href="#terminos" class="text-white">Términos y Condiciones</a>
        </p>
    </footer>

    <!-- Incluye la biblioteca jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <!-- Incluye la biblioteca Bootstrap JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>


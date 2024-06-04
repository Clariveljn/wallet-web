<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/img/favicon.png" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<title>Ver Movimientos</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid bg-dark p-2">
			<a href="${pageContext.request.contextPath}/pages/index.jsp"> <img
				src="${pageContext.request.contextPath}/img/logo-navbar.png"
				alt="logo Alke-Wallet" class="img-fluid logo-navbar" />
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav fs-5 ms-auto">
					<a class="nav-link me-4"
						href="${pageContext.request.contextPath}/pages/index.jsp">Salir</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="flex-grow-1">

		<div class="card p-3 mx-auto mt-4 text-center">



			<h1>Ver Movimientos</h1>
			<table>
				<tr>
					<th>Fecha</th>
					<th>Monto</th>
					<th>Descripción</th>
				</tr>
				<c:forEach var="movimiento" items="${movimientos}">
					<tr>
						<td>${movimiento.fecha}</td>
						<td>${movimiento.monto}</td>
						<td>${movimiento.descripcion}</td>
					</tr>
				</c:forEach>
			</table>
			<a class="btn btn-info btn-lg p-2 mb-2 d-block mx-auto mt-5" href="CuentaServlet?action=verSaldo&idCuenta=${cuenta.idCuenta}"> Volver a la cuenta</a>

		</div>
	</div>

	<footer class="footer bg-dark text-white py-3 text-center mt-4"">
		<p class="mb-1">Contacto: info@alkewallet.com</p>
		<p>
			<a href="#terminos" class="text-white">Términos y Condiciones</a>
		</p>
	</footer>
</body>
</html>
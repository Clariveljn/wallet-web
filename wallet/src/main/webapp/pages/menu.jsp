<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="js/auth.js"></script>
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/img/favicon.png" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<title>Alke-Wallet-Menu</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid bg-dark p-2">
			<a href="${pageContext.request.contextPath}/pages/index.jsp"> 
			<img
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
					<a class="nav-link" href="${pageContext.request.contextPath}/pages/menu.jsp">Menú</a> <a class="nav-link"
						href="${pageContext.request.contextPath}/pages/misCuentas.jsp">Mis cuentas</a> <a class="nav-link"
						href="${pageContext.request.contextPath}/pages/verMovimientos.jsp">Ver movimientos</a> <a
						class="nav-link me-4" href="${pageContext.request.contextPath}/pages/index.jsp">Salir</a>
				</div>
			</div>
		</div>
	</nav>


	<main class="flex-grow-1">
		<div class="container mt-4 mx-auto">
			<h2 class="text-center">Menú Principal</h2>
			<a 
				id="accounts" 
				href="${pageContext.request.contextPath}/pages/misCuentas.jsp"
				class="btn btn-info btn-lg p-2 mt-4 d-block mx-auto">
				Ver mis Cuentas
			</a>
			<a 
				id="transactions" 
				href="${pageContext.request.contextPath}/pages/verMovimientos.jsp"
				class="btn btn-info btn-lg p-2 mt-4 d-block mx-auto">
				Ver Movimientos
			</a>
			<div class="alert alertDeposit alert-info text-center mt-3"
				role="alert" style="display: none"></div>
			<div class="alert alertSendMoney alert-info text-center mt-3"
				role="alert" style="display: none"></div>
			<div class="alert alertTransactions alert-info text-center mt-3"
				role="alert" style="display: none"></div>
		</div>
	</main>

	<footer class="footer bg-dark text-white py-3 text-center mt-4">
		<p class="mb-1">Contacto: info@alkewallet.com</p>
		<p>
			<a href="#terminos" class="text-white">Términos y Condiciones</a>
		</p>
	</footer>
	<!-- bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.7.1.js"
		integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
		crossorigin="anonymous"></script>
	<script src="js/deposit.js"></script>
	<script src="js/menu.js"></script>
	<script src="js/sendmoney.js"></script>
</body>
</html>
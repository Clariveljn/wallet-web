<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/img/favicon.png" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
    <title>Depósito exitoso</title>
    <!-- Incluye la biblioteca Bootstrap CSS -->

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid p-2">
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
                    <div class="card-body">
                        <h2 class="card-title text-center">Depósito realizado con éxito</h2>
                        <p class="card-text">Titular: <%= request.getAttribute("titular") %></p>
                        <p class="card-text">Número de cuenta: <%= request.getAttribute("numeroCuenta") %></p>
                        <p class="card-text">Saldo actual: <%= request.getAttribute("saldo") %></p>
                        <a href="${pageContext.request.contextPath}/pages/menu.jsp" class="btn btn-info btn-block">Volver al menú</a> <!-- El botón ocupa todo el ancho disponible -->
                    </div>
                </div>
          
        </div>
    
    	<footer class="footer bg-dark text-white py-3 text-center mt-4">
		<p class="mb-1">Contacto: info@alkewallet.com</p>
		<p>
			<a href="#terminos" class="text-white">Términos y Condiciones</a>
		</p>
	</footer>
    <!-- Incluye la biblioteca jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <!-- Incluye la biblioteca Bootstrap  -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon.png" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <title>Alke-Wallet-Index</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg">
      <div class="container-fluid bg-dark p-2">
        <a href="${pageContext.request.contextPath}/pages/index.jsp">
          <img
            src="${pageContext.request.contextPath}/img/logo-navbar.png"
            alt="logo Alke-Wallet"
            class="img-fluid logo-navbar"
          />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav fs-5 ms-auto">
            <a class="nav-link me-4" href="${pageContext.request.contextPath}/pages/login.jsp">Iniciar sesión</a>
          </div>
        </div>
      </div>
    </nav>

    <div class="container mt-4">
      <div class="jumbotron text-center">
        <img src="${pageContext.request.contextPath}/img/logo-color.png" class="logo" alt="logo" />
        <h1 class="fs-2 text-center mt-3">¡Bienvenido a Alke-Wallet!</h1>
        <p class="lead text-center fs-5">
          Tu billetera digital confiable y segura.
        </p>
        <hr class="my-4" />
        <p class="text-center fs-6">
          Con Alke-Wallet, puedes realizar envíos y retiros de forma rápida y
          segura desde cualquier lugar.
        </p>
        <div class="text-center">
          <a
            class="btn btn-info btn-lg my-3"
            href="${pageContext.request.contextPath}/pages/registro.jsp"
            role="button"
            >Registrarme</a
          >
        </div>
      </div>
    </div>

    <footer class="footer bg-dark text-white py-3 text-center mt-4">
      <p class="mb-1">Contacto: info@alkewallet.com</p>
      <p><a href="#terminos" class="text-white">Términos y Condiciones</a></p>
    </footer>
    <!-- bootstrap -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <!-- jQuery -->
    <script
      src="https://code.jquery.com/jquery-3.7.1.js"
      integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
      crossorigin="anonymous"
    ></script>
  </body>
</html>
<%-- 
    Document   : confirmarClave
    Created on : 21/05/2021, 01:46:34 AM
    Author     : spier
--%>

<!-- definir que versi�n de HTML5 se usa para que el navegador interprete-->
<html lang="es-419">
    <!-- definir idioma -->
    <head>
        <!-- informacion que lee el navegador y no muestra -->
        <title>
            Confirmar Contrase�a
        </title>
        <!-- definit titulo -->
        <!-- metaetiquetas -->
        <meta charset="utf-8">
        <!-- permite lectura de caracteres especiales -->
        <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
        <!-- realizar la identificacion de resolucion de los diapositivos -->
        <script type="text/javascript" src="js/formulario.js"></script> 
        <link href="css/EstiloRec.css" rel="stylesheet" type="text/css"/>
        <!--enlazar hoja de estilo -->
        </link>
        </meta>
        </meta>
    </head>
</html>
<body oncopy="return false" onpaste="return false">
    <div class="container">
        <header>
        </header>
        <nav>
        </nav>
        <main>
            <div class="contenedor">
                <!-- agrupar contenido en bloques -->
                <!-- contenedor Informacion -->
                <div class="ContendedorTexto">
                    <div class="ContenedorDegrade">
                        <div class="contenedorText">
                            <a href="index.jsp"> <img class="logo" src="Imagen/LogoLina.svg"></a>
                            <h1 class="TTitulo">
                            </h1>
                            <p class="TDescripcion">
                                <strong>
                                    Optimizar
                                </strong>
                                los procesos de tu empresa
                                <br>
                                <strong>
                                    Mejorar
                                </strong>
                                la productividad de tus empleados
                                <br>
                                <strong>
                                    Aumentar
                                </strong>
                                tus ganancias
                            </p>
                        </div>
                    </div>
                </div>
                <div class="ContenedorFormulario">
                    <!-- contenedor formulario -->
                    <!-- insertar logo -->
                    <h1 class="titulo">
                        Confirmar Contrase�a
                    </h1>
                    <!-- dividir elementos en categorias, se asigna una clase para el elemento ejemplo h1 -->
                    <form action="Registrar" method="post">
                        
                        <label for="password">
                            Nueva Contrase�a:
                        </label>
                        <input id="password" name="textClaveC" 
                               placeholder="Nueva Contrase�a" required
                               type="password" onkeyup='check();'
                               pattern="[a-zA-Z0-9_*.%]{12,30}"
                               title="La contrase�a debe tener minimo 12 digitos,
                               letras, n�meros y car�cteres especiales(_*.%)"><br>

                        <label for="password2">
                            Confirmar Contrase�a:
                        </label>
                        <input id="password2" name="textclaveC2" 
                               placeholder="Confirmar Contrase�a" required
                               type="password" onkeyup='check();'
                               autocomplete="none"
                               pattern="[a-zA-Z0-9_*.%]{12,30}"
                               title="La contrase�a debe tener minimo 12 digitos,
                               letras, n�meros y car�cteres especiales(_*.%)"><br>
                        
                        <div class="alert"> <span id="alertamail"></span></div>
                        

                        
                        <div class="alert"> <span id="alerta"></span></div>
                        <div class="MensajeE">

                            <%
                                if (request.getAttribute("mensajeError") != null) {
                            %>
                            ${mensajeError}
                            <%} else {%>
                            ${mensajeExito}
                            <%}%>

                        </div>

                        <!--type submit-->
                        <input name="btnenviar" type="submit" value="Restablecer">
                        <br>
                        <br>
                    </form>
                    <span class="login">
                        <a href="Login.jsp">
                            Ingresar
                        </a>
                    </span>
                </div>
            </div>
        </main>
        <footer>
        </footer>
    </div>
</body>
</html>
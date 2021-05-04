<!-- definir que versión de HTML5 se usa para que el navegador interprete-->
<html lang="es-419">
    <!-- definir idioma -->
    <head>
        <!-- informacion que lee el navegador y no muestra -->
        <title>
            Restablecer Contraseña
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
                        Restablecer Contraseña
                    </h1>
                    <!-- dividir elementos en categorias, se asigna una clase para el elemento ejemplo h1 -->
                    <form action="Registrar" method="post">
                        
                        <label for="correo">
                            Correo Electronico:
                        </label>
                        <input id="correo" name="textCorreo" 
                               placeholder="cuenta@example.com" required
                               type="email" onkeyup='checkmail();'
                               pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}"
                               title="Carácter permitidos(_.)"><br>

                        <label for="ccorreo">
                            Confirmar Correo:
                        </label>
                        <input id="ccorreo" name="textCcorreo" 
                               placeholder="Confirme su correo" required
                               type="email" onkeyup='checkmail();'
                               autocomplete="none"
                               pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}"
                               title="Solo se permiten los siguientes cáracteres (_.)"><br>
                        <div class="alert"> <span id="alertamail"></span></div>
                        <div class="cdocument"> 
                            <label for="textDocumento">
                                Documento:
                            </label>
                            <select id="textTipoDocumento" 
                                    name="textTipoDocumento">
                                <option value="1">
                                    CC
                                </option>
                                <option value="2">
                                    CE
                                </option>
                            </select>
                            <input id="textDocumento" name="textDocumento" 
                                   placeholder="Ingrese su documento" 
                                   required type="text"
                                   pattern="[0-9]{6,30}"
                                   ti    tle="Ingrese solo números"><br>
                        </div>

                        
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
                        ¿Ya tiene cuenta?
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
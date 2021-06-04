<%@page import="com.lina.modelo.UsuarioDAO"%>
<%@page import="com.lina.vo.TipoUsuarioVO"%>
<%@page import="com.lina.modelo.TipoUsuarioDAO"%>
<%@page import="com.lina.vo.TipoDocumentoVO"%>
<%@page import="com.lina.modelo.TipoDocumentoDAO"%>
<%@page import="com.lina.vo.PersonasVO"%>
<%@page import="com.lina.vo.CategoriaProductoVO"%>
<%@page import="com.lina.modelo.CategoriaProductoDAO"%>
<%@page import="com.lina.vo.TipoProductoVO"%>
<%@page import="com.lina.modelo.TipoProductoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lina.modelo.ProductoDAO"%>
<%@page import="com.lina.vo.productoVO"%>
<%@page import="com.lina.vo.UsuariosVO"%>
<%  //validamos si existe sesion, de lo contrario redirigimos al login
    HttpSession misession = (HttpSession) request.getSession();
    if (misession == null || misession.getAttribute("usuarioSesion") == null) {
        request.setAttribute("MensajeU", "¡No se encontro ninguna sesion activa por favor inicia nuevamente.!");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
    UsuariosVO userSesion = (UsuariosVO) misession.getAttribute("usuarioSesion");
%> 
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Registrar Producto </title>
        <meta name="description" content="Ela Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="shortcut icon" href="colocarL">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link href="css/EstiloRe.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

    </head>
    <body>
        <!-- Left Panel -->

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">

                        <li class="menu-title">Menu</li><!-- /.menu-title -->

                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-truck"></i>Pedidos</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-table"></i><a href="RealizarPedidos.jsp">Nuevo Pedido</a></li>
                                <li><i class="fa fa-table"></i><a href="detallePedidos.jsp">Listar Pedidos</a></li>
                            </ul>
                        </li>


                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-envira"></i>Productos</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-envira"></i><a href="registrarProducto.jsp">Registrar Productos </a></li>
                                <li><i class="fa fa-envira"></i><a href="registrarProducto.jsp">Actualizar Productos </a></li>
                                <li><i class="fa fa-envira"></i><a href="eliminarProducto.jsp">Eliminar Productos </a></li>
                                <li><i class="fa fa-envira"></i><a href="detalleProducto.jsp">Imprimir Listado Productos </a></li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-user-circle-o "></i>Usuarios</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-user-circle-o "></i><a href="RegistroUsuario.jsp">Registrar Usuarios </a></li>
                                <li><i class="fa fa-user-circle-o "></i><a href="UsuariosActivos.jsp">Usuarios Activos </a></li>
                                <li><i class="fa fa-user-circle-o "></i><a href="ActualizarUsuario.jsp">Actualizar Usuarios </a></li>
                                <li><i class="fa fa-user-circle-o "></i><a href="eliminarUsuario.jsp">Eliminar Usuarios </a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside><!-- /#left-panel -->

        <!-- Left Panel -->

        <!-- Right Panel -->
        <div id="right-panel" class="right-panel">

            <!-- Header-->
            <header id="header" class="header">
                <div class="top-left">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="LinaHome.jsp"><img src="Imagen/LogoLina.svg" alt="Logo"></a>
                        <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
                        <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                    </div>
                </div>
                <div class="top-right">
                    <div class="header-menu">
                        <div class="header-left">

                        </div>

                        <div class="user-area dropdown float-right">
                            <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                            </a>

                            <div class="user-menu dropdown-menu">
                                <a class="nav-link" href="#"><i class="fa fa-user"></i>Perfil</a>
                                <a class="nav-link" href="Login.jsp"><i class="fa fa-power-off"></i>Salir</a>
                            </div>
                        </div>
                    </div>
                </div>
            </header><!-- /header -->
            <!-- Header-->
            <div class="breadcrumbs">
                <div class="breadcrumbs-inner">
                    <div class="row m-0">
                        <div class="col-sm-4">
                            <div class="page-header float-left">
                                <div class="page-title">
                                    <h1>Actualizar Usuarios</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="page-header float-right">
                                <div class="page-title">
                                    <ol class="breadcrumb text-right">
                                        <li><a href="#">Menu</a></li>
                                        <li><a href="#">Usuarios</a></li>
                                        <li class="active">Actualizar Usuario</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content">
                <div class="animated fadeIn">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Actualizar</strong>
                                </div>
                                <div class="card-body">
                                    <table class="table">
                                        <div class="contenedor">
                                            <!-- agrupar contenido en bloques -->
                                            <!-- contenedor Informacion -->
                                            <div class="ContenedorFormulario">
                                                <!-- contenedor formulario -->
                                                <!-- insertar logo -->
                                                <!-- dividir elementos en categorias, se asigna una clase para el elemento ejemplo h1 -->      
                                                <%
                                                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                                                    PersonasVO perVO = (PersonasVO) request.getAttribute("Datos Consultados"); //crear objeto asignandole un valor de una vez
                                                    //                                                                                                      
                                                    if (perVO != null) {                                                        
                                                %>  
                                                <form method="post" action="Registrar">
                                                    <label for="textid_usuario">
                                                        ID:
                                                    </label>
                                                    <input readonly type="text" name="textid_usuario" value="<%=perVO.getPid_usuario()%>" >
                                                    <label for="textDocumento">
                                                        Tipo De Usuario:
                                                    </label>
                                                    <select id="textTipoUsuario" 
                                                            name="textTipoUsuario">
                                                        <!--<option value="<=perVO.getPtipoUsuario()>"></option> -->
                                                        <%
                                                            TipoUsuarioDAO tipoUsuDao = new TipoUsuarioDAO(); //ella tiene el metodo
                                                            for (TipoUsuarioVO tipoUsuVO : tipoUsuDao.listar()) {
                                                        %>

                                                        <option value="<%=tipoUsuVO.getId_tipo_usuario()%>"><%=tipoUsuVO.getNombre_tipo_usuario()%> </option>

                                                        <%}%>
                                                    </select><br>
                                                    <label for="usuario">
                                                        Nombre Completo:
                                                    </label>
                                                    <input id="usuario" name="textNombre" 
                                                           placeholder="usuario" required 
                                                           type="text"
                                                           pattern="[a-zA-Z ]{10,20}"
                                                           required autofocus value="<%=perVO.getPusuario()%>"><br>
                                                    <!-- id amarrar input a label-->
                                                    <!--type clave-->
                                                    <label for="correo">
                                                        Correo Electronico:
                                                    </label>
                                                    <input id="correo" name="textCorreo" 
                                                           placeholder="cuenta@example.com" required
                                                           type="email" onkeyup='checkmail();'
                                                           pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}"
                                                           title="Carácter permitidos(_.)" value="<%=perVO.getPcorreo()%>"><br>

                                                    <label for="ccorreo">
                                                        Confirmar Correo:
                                                    </label>
                                                    <input id="ccorreo" name="textCcorreo" 
                                                           placeholder="Confirme su correo" required
                                                           type="email" onkeyup='checkmail();'
                                                           autocomplete="none"
                                                           pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}"
                                                           title="Solo se permiten los siguientes cáracteres (_.)" value="<%=perVO.getPcorreo()%>">
                                                    <div class="alert"> <span id="alertamail" ></span></div>
                                                    <div class="cdocument"> 
                                                        <label for="textDocumento">
                                                            Documento:
                                                        </label>
                                                        <select id="textTipoDocumento" 
                                                                name="textTipoDocumento">
                                                            <%
                                                                TipoDocumentoDAO tipoDocDao = new TipoDocumentoDAO(); //ella tiene el metod
                                                                for (TipoDocumentoVO tipoDocVO : tipoDocDao.listar()) {
                                                            %>

                                                            <option value="<%=tipoDocVO.getId_tipo_Documento()%>"><%=tipoDocVO.getNombre_Documento()%> </option>

                                                            <%}%>
                                                        </select>
                                                        <input id="textDocumento" name="textDocumento" 
                                                               placeholder="Ingrese su documento" 
                                                               required type="text"
                                                               pattern="[0-9]{6,30}"
                                                               title="Ingrese solo números" value="<%=perVO.getPdocumento()%>">
                                                    </div>

                                                    <label for="textDireccion">
                                                        Dirección:
                                                    </label>
                                                    <input id="textDireccion" name="textDireccion" 
                                                           placeholder="Ingrese su dirección" required
                                                           type="text" pattern="^[a-zA-Z0-9\\#\\-]{4,16}$" value="<%=perVO.getPdireccion()%>"><br>

                                                    <label for="textCelular">
                                                        Celular:
                                                    </label>
                                                    <input id="textCelular" name="textCelular" 
                                                           placeholder="Número de Celular" 
                                                           required="" type="text" pattern="^[3]\d{9}$"
                                                           title="El número ingresado debe iniciar en 3, minimo 10 carácteres" value="<%=perVO.getPcelular()%>"><br>

                                                    <label for="textCelular">
                                                        Telefono Fijo:
                                                    </label>
                                                    <input id="textFijo" name="textFijo" 
                                                           placeholder="Número Fijo" 
                                                           required="" type="text" pattern="^[3]\d{9}$"
                                                           title="El número ingresado debe iniciar en 3, minimo 10 carácteres" value="<%=perVO.getPtelefonoFijo()%>"><br>
                                                    
                                                    <div class="alert"> <span id="alerta"></span></div>
                                                    <input readonly id="password" name="textClaveR" 
                                                           placeholder="Contraseña" required
                                                           type="hidden" onkeyup='check();'
                                                           pattern="[a-zA-Z0-9_*.%]{12,30}"
                                                           title="La contraseña debe tener minimo 12 digitos,
                                                           letras, números y carácteres especiales(_*.%)" value="<%=perVO.getPcontraseña()%>">
                                                    <button> Actualizar

                                                    </button>
                                                    <input type="hidden" value="2" name="opcion" > <%-- 39 value es el numero de caso, contenido oculto, opcion valor a recoger --%>   
                                                </form>
                                                <div class="MensajeE">

                                                    <%
                                                        if (request.getAttribute("mensajeError") != null) {
                                                    %>
                                                    ${mensajeError}
                                                    <%} else {%>
                                                    ${mensajeExito}
                                                    <%}%>

                                                </div>
                                                <%}
                                                %>  
                                                <a href="ActualizarUsuario.jsp" >  <button class="btn1" >Volver</button></a>
                                            </div>
                                        </div>                                 
                                    </table> 
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div><!-- .animated -->
        </div><!-- .content -->   

        <div class="clearfix"></div>
        <footer class="site-footer">
            <div class="footer-inner bg-white">
                <div class="row">
                    <div class="col-sm-6">
                        Copyright &copy; 2021 LinAdmin
                    </div>
                    <div class="col-sm-6 text-right">
                        Diseñado por <a href="#">LinAdmin</a>
                    </div>
                </div>
            </div>
        </footer>

    </div><!-- /#right-panel -->

    <!-- Right Panel -->

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="assets/js/main.js"></script>


</body>
</html>

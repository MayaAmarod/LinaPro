<%-- 
    Document   : actualizarPedido
    Created on : 6/05/2021, 05:59:22 PM
    Author     : Nidia
--%>

<%@page import="com.lina.modelo.UsuarioDAO"%>
<%@page import="com.lina.modelo.UsuarioDAO"%>
<%@page import="com.lina.vo.PedidoVO"%>
<%@page import="com.lina.vo.UsuariosVO"%>
<%  //validamos si existe sesion, de lo contrario redirigimos al login
HttpSession misession= (HttpSession) request.getSession();
if(misession==null || misession.getAttribute("usuarioSesion")==null ){ 
    request.setAttribute("MensajeU", "¡No se encontro ninguna sesion activa por favor inicia nuevamente.!");
    request.getRequestDispatcher("Login.jsp").forward(request, response);
}
 UsuariosVO userSesion= (UsuariosVO) misession.getAttribute("usuarioSesion");
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <link href="css/EstiloProd.css" rel="stylesheet" type="text/css"/>
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
                                <li><i class="fa fa-truck"></i><a href="registarPedido.jsp">Gestionar Pedidos</a></li>
                            </ul>
                        </li>

                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-envira"></i>Productos</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-envira"></i><a href="registrarProducto.jsp">Gestionar Productos </a></li>
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
                                <a class="nav-link" href="#"><i class="fa fa-user"></i>My Profile</a>
                                <a class="nav-link" href="Login.jsp"><i class="fa fa-power-off"></i>Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </header><!-- /header -->
            <!-- Header-->

              <div class="col-lg-5">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Actualizar Pedido</strong>
                                </div>
                                <div class="card-body">
                                    <table class="table">
                                        <div class="contenedor">
                                            <!-- agrupar contenido en bloques -->
                                            <!-- contenedor Informacion -->
                                         
            
       
        <%
            PedidoVO pedVO = (PedidoVO) request.getAttribute("Datos Consultados");
            //
            if (pedVO != null) {

        %>

        <form method="post" action="Pedido">

            <table>

                <tr>
                    <th>


                        ID Usuario  <br>

                        <select name="textid_usuario"  value="<%=pedVO.getId_Usuario()%>" >
                            <%
                                UsuarioDAO usuarioDAO = new UsuarioDAO();
                                for (UsuariosVO user : usuarioDAO.listarUsuarios()) {
                            %>

                            <option value="<%=user.getIdUsusario()%>"><%=user.getNombre()%> </option>

                            <%}%>
                        </select> <br> <br>

                        Fecha de Pedido  <br>
                        <input type="date" name="textfecha_pedido" value="<%=pedVO.getFecha_Pedido()%>" ><br> <br>

                        Fecha de Entrega <br>
                        <input type="date" name="textfecha_entrega" value="<%=pedVO.getFecha_Entrega()%>" ><br> <br>

                        Forma de Envio <br>
                        <input type="text" name="textforma_envio" value="<%=pedVO.getForma_Envio()%>" > <br> <br>



                    </th>

                </tr>

            </table>  <br>
            <button> Actualizar

            </button>
            <input type="hidden" value="<%=pedVO.getId_Pedido()%>" name="id_pedido" >
            <input type="hidden" value="2" name="opcion" > <%-- 39 value es el numero de caso, contenido oculto, opcion valor a recoger --%>
        </form> <br>


        <%}
        %>
        <a href="registarPedido.jsp" >Volver</a>
        <div style="color:green"> <%-- codigo java --%>
            <%
                if (request.getAttribute("mensajeError") != null) {
            %>
            <%-- imprimir mensaje en jsp ${} --%>

            ${mensajeError}
            <%
            } else { %>
            ${mensajeExito}
            <%}%>
        </div>

    </centeR>
                                     </div>
                                        </div>

                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
               
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

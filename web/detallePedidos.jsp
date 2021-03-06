<%@page import="com.lina.vo.PedidoVO"%>
<%@page import="com.lina.modelo.PedidoDAO"%>
<%@page import="com.lina.vo.PedidoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lina.modelo.ProductoDAO"%>
<%@page import="com.lina.vo.productoVO"%>
<%@page import="com.lina.vo.UsuariosVO"%>
<%  //validamos si existe sesion, de lo contrario redirigimos al login
    HttpSession misession = (HttpSession) request.getSession();
    if (misession == null || misession.getAttribute("usuarioSesion") == null) {
        request.setAttribute("MensajeU", "?No se encontro ninguna sesion activa por favor inicia nuevamente.!");
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
        <title>Lina </title>
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
        <link href="css/Estilo.css" rel="stylesheet" type="text/css"/>
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Productos</a>
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
                                <a class="nav-link" href="#"><i class="fa fa-user"></i>My Profile</a>
                                <a class="nav-link" href="Login.jsp"><i class="fa fa-power-off"></i>Logout</a>
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
                                    <h1>Pedidos Registrados</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="page-header float-right">
                                <div class="page-title">
                                    <ol class="breadcrumb text-right">
                                        <li><a href="#">Dashboard</a></li>
                                        <li class="active"><a href="#">Pedidos</a></li>

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

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Pedidos</strong>
                                </div>
                                <div class="card-body">
                                    <div style="color:green"> <%-- codigo java --%>
                                        <%
                                            if (request.getAttribute("mensajeExito") != null) {
                                        %>
                                        <%-- imprimir mensaje en jsp ${} --%>

                                        ${mensajeExito}
                                        <%
                                            } %>

                                    </div>
                                    <div class="card-header">
                                         <form action="generarPDFped.jsp" method="post" target="_blank">
                                            <strong class="card-title">Pedidos</strong> 
                                            <button class="btn1">Generar Reporte PDF</button>
                                         </form><br>
                                         
                                        <form method="post" action="Pedido">
                                            <strong class="card-title">C?digo Pedido</strong>
                                            <input type="text" name="textid_pedido">
                                            <button class="btn1">Actualizar</button>
                                            <input type="hidden" value="3" name="opcion" > 
                                        </form>
                                    </div> 
                                    <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID Pedido</th>
                                                <th>Nombre Usuario</th>
                                                <th>Fecha de Pedido</th>
                                                <th>Fecha de Entrega</th>
                                                <th>Forma de Envio</th>
                                                <th>Estado de Pedido</th>
                                                <th>Ver Productos</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                PedidoVO pedVO = new PedidoVO();
                                                PedidoDAO pedDAO = new PedidoDAO();

                                                ArrayList<PedidoVO> listaPedidos = pedDAO.listarPedidosConNombreUsuario();

                                                for (int i = 0; i < listaPedidos.size(); i++) {
                                                    pedVO = listaPedidos.get(i);

                                            %>
                                            <tr>
                                                <td><%=pedVO.getId_Pedido()%></td>
                                                <td><%=pedVO.getNombreUsuario()%></td>
                                                <td><%=pedVO.getFecha_Pedido()%></td>
                                                <td><%=pedVO.getFecha_Entrega()%></td>
                                                 <td><%=pedVO.getForma_Envio()%></td>
                                                 <td>
                                                     <div style="display: flex;">
                                                         <form method="post" action="CambiarEstadoPedido">
                                                             <select name="estado" required="true"   >
                                                                 <option selected="selected"><%=pedVO.getEstadoPedido()%> </option>
                                                                 <option value="Nuevo">Nuevo </option>
                                                                 <option value="Despachado">Despachado</option>
                                                                 <option value="Entregado">Entregado</option>
                                                                 <option value="Confirmado">Confirmado</option>
                                                                 <option value="Finalizado">Finalizado</option>
                                                                 <option value="Cancelado">Cancelado</option>
                                                             </select> 
                                                             <input type="hidden" name="textid_pedido" value="<%=pedVO.getId_Pedido()%>" >
                                                             <button style="width: 50px; margin-left: 15px" > <i class="fa fa-save"></i></button>
                                                         </form>
                                                     </div>
                                                 </td>

                                                <td><form method="post" action="RealizarPedidoControlador">
                                                        <input type="hidden" name="textid_pedido" value="<%=pedVO.getId_Pedido()%>" >
                                                        <input type="hidden" name="opcion" value="detalle_pedido" >
                                                        <button >Ver Detalle</button>
                                                    </form></td>
                                            </tr>
                                            <%}%>

                                        </tbody>
                                    </table>
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
                            Dise?ado por <a href="#">LinAdmin</a>
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


        <script src="assets/js/lib/data-table/datatables.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/jszip.min.js"></script>
        <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
        <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
        <script src="assets/js/init/datatables-init.js"></script>


        <script type="text/javascript">
            $(document).ready(function () {
                $('#bootstrap-data-table-export').DataTable();
            });
        </script>


    </body>
</html>

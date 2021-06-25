
<%@page import="java.util.List"%>
<%@page import="com.lina.modelo.UsuarioDAO"%>
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
        request.setAttribute("MensajeU", "No se encontro ninguna sesion activa por favor inicia nuevamente.!");
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
                                    <%
                                        boolean opcionConfirmarPedido = ((String) request.getAttribute("opcion")).equals("confirmar_pedido");
                                        if (opcionConfirmarPedido) {
                                    %>
                                    <h1>Confirmar Pedido</h1>
                                    <% } else { %>
                                    <h1>Detalle Pedido</h1>
                                    <% }   %>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="page-header float-right">
                                <div class="page-title">
                                    <ol class="breadcrumb text-right">
                                        <li><a href="#">Menu</a></li>
                                        <li><a href="#">Productos</a></li>
                                            <%  if (opcionConfirmarPedido) { %>
                                        <li class="active">Confirmar Pedido</li>
                                            <% } else { %>
                                        <li class="active">Detalle Pedido</li>
                                            <% }   %>

                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <form method="post" action="ConfirmarPedidoControlador">
                <div class="content">
                    <div class="animated fadeIn">
                        <div class="row">
                            <div class="col-lg-7">
                                <div class="card">
                                    <div class="card-header">

                                        <strong class="card-title">Productos Comprados</strong>


                                    </div> 

                                    <div class="table-stats order-table ov-h">
                                        <table class="table ">
                                            <thead>
                                                <tr>
                                                    <th>Imagen</th>
                                                    <th>C&oacutedigo Producto</th>
                                                    <th>Nombre Producto</th>
                                                    <th>Precio</th>
                                                    <th>Cantidad </th>
                                                    <th>Valor Final</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                </tr>

                                                <%
                                                    List<productoVO> cestaDeproductosSeleccionados = (List<productoVO>) request.getAttribute("cestaDeproductosSeleccionados");
                                                    for (productoVO proVO : cestaDeproductosSeleccionados) {
                                                %>            
                                                <tr>
                                                    <% if (proVO.getUrl_imagen() != null && (proVO.getUrl_imagen().toLowerCase().contains("png") || proVO.getUrl_imagen().toLowerCase().contains("jpg"))) {%>   
                                                    <td><img src="<%=proVO.getUrl_imagen()%>" width="80px" class="rounded-circle border border-light rounded-3"></td>
                                                        <%} else {   %>  
                                                    <td><img src="Imagen/productosIcono.png" width="80px" class="rounded-circle border border-light rounded-3"></td>
                                                        <%  }%>  
                                                    <td><%=proVO.getId_producto()%></td>
                                                    <td><%=proVO.getNombre_producto()%></td>
                                                    <td><%=proVO.getPrecio()%></td>
                                                    <td><%=proVO.getCantidadAComprar()%></td>
                                                    <td><%=proVO.getSubtotal()%></td>
                                                </tr>
                                                <%}%>                  
                                            <tfoot>
                                                <tr>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td>Valor Total</td>
                                                    <%  Double precioTotalPedido = (Double) request.getAttribute("precioTotalPedido");%>
                                                    <td><%=precioTotalPedido%></td>
                                                </tr>
                                            </tfoot>

                                            </tbody>
                                        </table>
                                    </div> <!-- /.table-stats -->
                                    <div style="color:red"> <%-- codigo java --%>
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
                                </div>
                                <%  if (opcionConfirmarPedido) { %>
                                <a href="LinaHome.jsp"><button class="btn btn-green" >Confirmar Pedido</button></a>
                                <% } else { %>
                                <a href="detallePedidos.jsp">Regrasar</a>
                                <% }   %>

                            </div>


                            <div class="col-lg-5">
                                <div class="card">
                                    <div class="card-header">
                                        <strong class="card-title">Datos de Envio</strong>
                                    </div>
                                    <div class="card-body">
                                        <table class="table">
                                            <div class="">
                                                <!-- agrupar contenido en bloques -->
                                                <!-- contenedor Informacion -->
                                                <div class="">
                                                    <!-- contenedor formulario -->
                                                    <!-- insertar logo -->
                                                    <!-- dividir elementos en categorias, se asigna una clase para el elemento ejemplo h1 -->
                                                    <%  PedidoVO pedVO = (PedidoVO) request.getAttribute("Pedido");

                                                        UsuarioDAO usuarioDao = new UsuarioDAO();
                                                        UsuariosVO user = usuarioDao.getUsuarioPorId(pedVO.getId_Usuario());
                                                    %>

                                                    <div class="container">
                                                        <div class="row">
                                                            <div class="col">
                                                                  <label ><b>fecha de pedido:</b> </label>
                                                            </div>
                                                            <div class="col">
                                                                  <label ><%=pedVO.getFecha_Pedido()%></label>
                                                            </div>
                                                        </div>
                                                    </div><br>
                                                      <div class="container">
                                                        <div class="row">
                                                            <div class="col">
                                                                  <label ><b>Usuario: </b></label>
                                                            </div>
                                                            <div class="col">
                                                                <label ><%=user.getNombre()%></label>
                                                            </div>
                                                        </div>
                                                    </div><br>
                                                      <div class="container">
                                                        <div class="row">
                                                            <div class="col">
                                                                   <label ><b>Direccion de entrega:</b> </label>
                                                            </div>
                                                            <div class="col">
                                                                 <label ><%=user.getDirreccion()%></label>
                                                            </div>
                                                        </div>
                                                    </div><br>
                                                      <div class="container">
                                                        <div class="row">
                                                            <div class="col">
                                                                 <label ><b>fecha de entrega: </b></label>
                                                            </div>
                                                            <div class="col">
                                                                <label ><%=pedVO.getFecha_Entrega()%></label>
                                                            </div>
                                                        </div>
                                                    </div><br>
                                                      <div class="container">
                                                        <div class="row">
                                                            <div class="col">
                                                                <label ><b>Forma de envio:</b> </label>
                                                            </div>
                                                            <div class="col">
                                                                 <label ><%=pedVO.getForma_Envio()%></label>
                                                            </div>
                                                        </div>
                                                    </div>

                                                  
                                                  
                                                  
                                                    
                                                 
                                                   
                                                   
                                                    
                                                    
                                                   


                                                </div>

                                            </div>
                                    </div>

                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- .animated -->
        </div><!-- .content -->
    </form>


    <div class="clearfix"></div>

    <footer class="site-footer">
        <div class="footer-inner bg-white">
            <div class="row">
                <div class="col-sm-6">
                    Copyright &copy; 2021 LinAdmin
                </div>
                <div class="col-sm-6 text-right">
                    Dise�ado por <a href="#">LinAdmin</a>
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
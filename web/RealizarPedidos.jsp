
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
                                <li><i class="fa fa-table"></i><a href="registrarProducto.jsp">Registrar </a></li>
                                <li><i class="fa fa-table"></i><a href="actualizarProducto.jsp">Actualizar Y Eliminar </a></li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-user-circle-o "></i>Usuarios</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-user-circle-o "></i><a href="RegistroUsuario.jsp">Registrar Usuarios </a></li>
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
                                    <h1>Realizar Pedido</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="page-header float-right">
                                <div class="page-title">
                                    <ol class="breadcrumb text-right">
                                        <li><a href="#">Menu</a></li>
                                        <li><a href="#">Productos</a></li>
                                        <li class="active">Realizar Pedido</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <form method="post" action="RealizarPedidoControlador">
                <div class="content">
                    <div class="animated fadeIn">
                        <div class="row">
                            <div class="col-lg-7">
                                <div class="card">
                                    <div class="card-header">

                                        <strong class="card-title">Seleccione los Productos</strong>


                                    </div> 

                                    <div class="table-stats order-table ov-h">
                                        <input type="hidden" name="opcion" value="confirmar_pedido" >
                                        <table class="table ">
                                            <thead>
                                                <tr>
                                                    <th>Imagen</th>
                                                    <th>Codigo Producto</th>
                                                    <th>Nombre Producto</th>
                                                    <th>Precio</th>
                                                    <th>Cantidad </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                </tr>

                                                <%
                                                    productoVO proVO = new productoVO(); //se deja vacio porque no va a enviar sino recibir, no pasa x controlador
                                                    ProductoDAO proDAO = new ProductoDAO(); //no va a hacer iPeraciones con datos del VO
                                                    //vamos a vehiculo DAO seleccionar variables y generan constructor vacio para llamarlo
                                                    ArrayList<productoVO> listaProductos = proDAO.listar(); //se declara un array para recibir los datos <se coloca el objeto, STRING, BOOLEAN>
                                                    for (int i = 0; i < listaProductos.size(); i++) {
                                                        proVO = listaProductos.get(i);
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
                                                    <td><input type="number" name="cantidad_<%=proVO.getId_producto()%>"  class="form-control" style="width: 80px; float: right" value="0"  min="0" max="<%=proVO.getUnidades_existentes()%>"></td>
                                                </tr>
                                                <%}%>                  


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
                                <a href="LinaHome.jsp"><button> Realizar Pedido</button></a>
                            </div>


                            <div class="col-lg-5">
                                <div class="card">
                                    <div class="card-header">
                                        <strong class="card-title">Datos de Envio</strong>
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


                                                    <label for="idusuario">
                                                        Usuario
                                                    </label>
                                                    <select name="textid_usuario" required="true" ><br> <br>
                                                        <option disabled selected value>Seleccione...</option> 
                                                        <%
                                                            UsuarioDAO usuarioDAO = new UsuarioDAO();
                                                            for (UsuariosVO user : usuarioDAO.listarUsuarios()) {
                                                        %>

                                                        <option value="<%=user.getIdUsusario()%>"><%=user.getNombre()%> </option>

                                                        <%}%>
                                                    </select> 

                                                    <br> <br>

                                                    <label>
                                                        Fecha entrega:  <br>
                                                    </label>
                                                    <input type="date" name="textfecha_entrega" required="true" ><br> <br>

                                                    <label>
                                                        Forma de envio: <br>
                                                    </label>

                                                    <select name="textforma_envio" required="true" >
                                                        <option disabled selected value>Seleccione...</option> 
                                                        <option value="Envio Normal">Envio Normal</option>
                                                        <option value="Envio Express">Envio Express</option>
                                                        <option value="Recoge en Tienda">Recoge en Tienda</option>
                                                    </select> <br> <br>




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
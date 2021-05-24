<%@page import="com.lina.modelo.PedidoDAO"%>
<%@page import="com.lina.vo.PedidoVO"%>
<%@page import="com.lina.vo.CategoriaProductoVO"%>
<%@page import="com.lina.modelo.CategoriaProductoDAO"%>
<%@page import="com.lina.vo.TipoProductoVO"%>
<%@page import="com.lina.modelo.TipoProductoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lina.modelo.ProductoDAO"%>
<%@page import="com.lina.vo.productoVO"%>
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
                                <li><i class="fa fa-truck"></i><a href="registarPedido.jsp">Registar Pedido</a></li>
                                <li><i class="fa fa-truck"></i><a href="Pedidos.jsp">Basic Table</a></li>
                            </ul>
                        </li>

                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Productos</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-table"></i><a href="registrarProducto.jsp">Registrar </a></li>
                                <li><i class="fa fa-table"></i><a href="actualizarProducto.jsp">Actualizar Y Eliminar </a></li>

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
                                <a class="nav-link" href="#"><i class="fa fa-power-off"></i>Logout</a>
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
                                    <h1>Registar Pedido</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="page-header float-right">
                                <div class="page-title">
                                    <ol class="breadcrumb text-right">
                                        <li><a href="#">Menu</a></li>
                                        <li><a href="#">Pedidos</a></li>
                                        <li class="active">Registrar Pedidos</li>
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
                        <div class="col-lg-7">
                            <div class="card">
                                <div class="card-header">
                                    <form method="post" action="Pedido">
                                        <strong class="card-title">C�digo Pedido</strong>
                                        <input type="text" name="textid_pedido">
                                        <button class="btn1">Actualizar</button>
                                        <input type="hidden" value="3" name="opcion" > 
                                    </form>
                                </div> 

                                <div class="table-stats order-table ov-h">
                                    <table class="table ">
                                        <thead>
                                            <tr>
                                                <th>ID Pedido</th>
                                                <th>ID Usuario</th>
                                                <th>Fecha de Pedido</th>
                                                <th>Fecha de Entrega</th>
                                                <th>Forma de Envio</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            </tr>

                                            <%

                                                PedidoVO pedVO = new PedidoVO();
                                                PedidoDAO pedDAO = new PedidoDAO();

                                                ArrayList<PedidoVO> listaPedidos = pedDAO.listar();

                                                for (int i = 0; i < listaPedidos.size(); i++) {
                                                    pedVO = listaPedidos.get(i);

                                            %>           
                                            <tr>
                                                <td><%=pedVO.getId_Pedido()%></td>
                                                <td><%=pedVO.getId_Usuario()%></td>
                                                <td><%=pedVO.getFecha_Pedido()%></td>
                                                <td><%=pedVO.getFecha_Entrega()%></td>
                                                <td><%=pedVO.getForma_Envio()%></td>
                                            </tr>
                                            <%}%>               


                                        </tbody>
                                    </table>
                                </div> <!-- /.table-stats -->
                            </div>
                            <a href="detallePedidos.jsp"><button> Ver Detalle de Pedidos</button></a>
                        </div>


                        <div class="col-lg-5">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Registrar</strong>
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
                                                <form method="post" action="Pedido">

                                                    <label for="idusuario">
                                                        id usuario:
                                                    </label>
                                                    <input type="text" name="textid_usuario">

                                                    <label for="textfecha_pedido">
                                                        Fecha pedido:
                                                    </label>
                                                    <input type="date" id="textfecha_pedido" name="textfecha_pedido"> <br>

                                                    <label>
                                                        Fecha entrega:  <br>
                                                    </label>
                                                    <input type="date" name="textfecha_entrega">

                                                    <label>
                                                        Forma de envio: <br>
                                                    </label>
                                                    <input type="text" name="textforma_envio"> 

                                                    <button> Registrar Pedido</button>
                                                    <input type="hidden" value="1" name="opcion"> <%-- 39 value es el numero de caso, contenido oculto, opcion valor a recoger --%>
                                                    

                                                    </div>
                                                </form>
                                            </div>
                                        </div>

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


    </body>
</html>
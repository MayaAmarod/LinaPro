package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lina.vo.CategoriaProductoVO;
import com.lina.modelo.CategoriaProductoDAO;
import com.lina.vo.TipoProductoVO;
import com.lina.modelo.TipoProductoDAO;
import java.util.ArrayList;
import com.lina.modelo.ProductoDAO;
import com.lina.vo.productoVO;

public final class registrarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\" lang=\"\"> <!--<![endif]-->\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>Registrar Producto </title>\n");
      out.write("        <meta name=\"description\" content=\"Ela Admin - HTML5 Admin Template\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"colocarL\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/cs-skin-elastic.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/lib/datatable/dataTables.bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("        <link href=\"css/EstiloProd.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("\n");
      out.write("        <!-- <script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js\"></script> -->\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Left Panel -->\n");
      out.write("\n");
      out.write("        <aside id=\"left-panel\" class=\"left-panel\">\n");
      out.write("            <nav class=\"navbar navbar-expand-sm navbar-default\">\n");
      out.write("\n");
      out.write("                <div id=\"main-menu\" class=\"main-menu collapse navbar-collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("\n");
      out.write("                        <li class=\"menu-title\">Menu</li><!-- /.menu-title -->\n");
      out.write("\n");
      out.write("                        <li class=\"menu-item-has-children active dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-truck\"></i>Pedidos</a>\n");
      out.write("                            <ul class=\"sub-menu children dropdown-menu\">\n");
      out.write("                                <li><i class=\"fa fa-truck\"></i><a href=\"LinaHome.jsp\">Basic Table</a></li>\n");
      out.write("                                <li><i class=\"fa fa-truck\"></i><a href=\"Pedidos.jsp\">Basic Table</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"menu-item-has-children active dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-table\"></i>Productos</a>\n");
      out.write("                            <ul class=\"sub-menu children dropdown-menu\">\n");
      out.write("                                <li><i class=\"fa fa-table\"></i><a href=\"registrarProducto.jsp\">Registrar </a></li>\n");
      out.write("                                <li><i class=\"fa fa-table\"></i><a href=\"actualizarProducto.jsp\">Actualizar Y Eliminar </a></li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div><!-- /.navbar-collapse -->\n");
      out.write("            </nav>\n");
      out.write("        </aside><!-- /#left-panel -->\n");
      out.write("\n");
      out.write("        <!-- Left Panel -->\n");
      out.write("\n");
      out.write("        <!-- Right Panel -->\n");
      out.write("\n");
      out.write("        <div id=\"right-panel\" class=\"right-panel\">\n");
      out.write("\n");
      out.write("            <!-- Header-->\n");
      out.write("            <header id=\"header\" class=\"header\">\n");
      out.write("                <div class=\"top-left\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"LinaHome.jsp\"><img src=\"Imagen/LogoLina.svg\" alt=\"Logo\"></a>\n");
      out.write("                        <a class=\"navbar-brand hidden\" href=\"./\"><img src=\"images/logo2.png\" alt=\"Logo\"></a>\n");
      out.write("                        <a id=\"menuToggle\" class=\"menutoggle\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"top-right\">\n");
      out.write("                    <div class=\"header-menu\">\n");
      out.write("                        <div class=\"header-left\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"user-area dropdown float-right\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle active\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                <img class=\"user-avatar rounded-circle\" src=\"images/admin.jpg\" alt=\"User Avatar\">\n");
      out.write("                            </a>\n");
      out.write("\n");
      out.write("                            <div class=\"user-menu dropdown-menu\">\n");
      out.write("                                <a class=\"nav-link\" href=\"#\"><i class=\"fa fa-user\"></i>My Profile</a>\n");
      out.write("                                <a class=\"nav-link\" href=\"#\"><i class=\"fa fa-power-off\"></i>Logout</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header><!-- /header -->\n");
      out.write("            <!-- Header-->\n");
      out.write("\n");
      out.write("            <div class=\"breadcrumbs\">\n");
      out.write("                <div class=\"breadcrumbs-inner\">\n");
      out.write("                    <div class=\"row m-0\">\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <div class=\"page-header float-left\">\n");
      out.write("                                <div class=\"page-title\">\n");
      out.write("                                    <h1>Registar Productos</h1>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-8\">\n");
      out.write("                            <div class=\"page-header float-right\">\n");
      out.write("                                <div class=\"page-title\">\n");
      out.write("                                    <ol class=\"breadcrumb text-right\">\n");
      out.write("                                        <li><a href=\"#\">Menu</a></li>\n");
      out.write("                                        <li><a href=\"#\">Productos</a></li>\n");
      out.write("                                        <li class=\"active\">Registrar Productos</li>\n");
      out.write("                                    </ol>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"animated fadeIn\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-7\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <form action=\"Productos\" method=\"post\">\n");
      out.write("                                    <strong class=\"card-title\">Código Producto</strong>\n");
      out.write("                                    <input type=\"text\" name=\"textid_producto\">\n");
      out.write("                                                <button class=\"btn1\">Actualizar</button>\n");
      out.write("            <input type=\"hidden\" value=\"3\" name=\"opcion\" > \n");
      out.write("             </form>\n");
      out.write("                                </div> \n");
      out.write("                                \n");
      out.write("                                <div class=\"table-stats order-table ov-h\">\n");
      out.write("                                    <table class=\"table \">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Código</th>\n");
      out.write("                                                <th>Nombre Producto</th>\n");
      out.write("                                                <th>Planta</th>\n");
      out.write("                                                <th>Peso</th>\n");
      out.write("                                                <th>Unidades Existentes</th>\n");
      out.write("                                                <th>Precio</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            ");


                                                productoVO proVO = new productoVO(); //se deja vacio porque no va a enviar sino recibir, no pasa x controlador
                                                ProductoDAO proDAO = new ProductoDAO(); //no va a hacer iPeraciones con datos del VO
                                                //vamos a vehiculo DAO seleccionar variables y generan constructor vacio para llamarlo
                                                ArrayList<productoVO> listaProductos = proDAO.listar(); //se declara un array para recibir los datos <se coloca el objeto, STRING, BOOLEAN>

                                                for (int i = 0; i < listaProductos.size(); i++) {
                                                    proVO = listaProductos.get(i);

                                            
      out.write("            \n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>");
      out.print(proVO.getId_producto());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(proVO.getNombre_producto());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(proVO.getId_planta());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(proVO.getPeso());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(proVO.getUnidades_existentes());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(proVO.getPrecio());
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            ");
}
      out.write("                  \n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div> <!-- /.table-stats -->\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"LinaHome.jsp\"><button> Ver Detalle de Productos</button></a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col-lg-5\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <strong class=\"card-title\">Registrar</strong>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <div class=\"contenedor\">\n");
      out.write("                                            <!-- agrupar contenido en bloques -->\n");
      out.write("                                            <!-- contenedor Informacion -->\n");
      out.write("                                            <div class=\"ContenedorFormulario\">\n");
      out.write("                                                <!-- contenedor formulario -->\n");
      out.write("                                                <!-- insertar logo -->\n");
      out.write("                                                <!-- dividir elementos en categorias, se asigna una clase para el elemento ejemplo h1 -->\n");
      out.write("                                                <form method=\"post\" action=\"Productos\"> \n");
      out.write("\n");
      out.write("                                                    <label for=\"tipoProducto\">\n");
      out.write("                                                        Tipo de Producto:\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <select name=\"textid_tipo_producto\"><br> <br>\n");
      out.write("                                                        <option>Seleccione...</option> \n");
      out.write("                                                        ");

                                                            TipoProductoDAO tipProDao = new TipoProductoDAO(); //ella tiene el metodo
                                                            for (TipoProductoVO tipProVO : tipProDao.listar()) {
                                                        
      out.write("\n");
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(tipProVO.getId_tipo_producto());
      out.write('"');
      out.write('>');
      out.print(tipProVO.getNombre_tipo());
      out.write(" </option>\n");
      out.write("\n");
      out.write("                                                        ");
}
      out.write("\n");
      out.write("                                                    </select> \n");
      out.write("                                                    <!-- id amarrar input a label-->\n");
      out.write("                                                    <!--type clave-->\n");
      out.write("                                                    <label for=\"Categoria\">\n");
      out.write("                                                        Categoria:\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <select name=\"textid_categoria\"><br> <br>\n");
      out.write("                                                        <option>Seleccione...</option> \n");
      out.write("                                                        ");

                                                            CategoriaProductoDAO catProDao = new CategoriaProductoDAO(); //ella tiene el metodo
                                                            for (CategoriaProductoVO catVO : catProDao.listar()) {
                                                        
      out.write("\n");
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(catVO.getId_categoria());
      out.write('"');
      out.write('>');
      out.print(catVO.getNombre_categoria());
      out.write(" </option>\n");
      out.write("\n");
      out.write("                                                        ");
}
      out.write("\n");
      out.write("                                                    </select>\n");
      out.write("                                                    <label for=\"nomProducto\">\n");
      out.write("                                                        Nombre Producto:\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <input type=\"text\" name=\"textnombre_producto\"> \n");
      out.write("                                                    <label for=\"plaMaq\">\n");
      out.write("                                                        Planta Maquilado : \n");
      out.write("                                                    </label>\n");
      out.write("                                                    <input type=\"text\" name=\"textid_planta\"> <br>\n");
      out.write("\n");
      out.write("                                                    <label>\n");
      out.write("                                                        Peso:  <br>\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <input type=\"text\" name=\"textpeso\"> \n");
      out.write("\n");
      out.write("                                                    <label>\n");
      out.write("                                                        Imagen: <br>\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <input type=\"text\" name=\"texturl_imagen\">   \n");
      out.write("\n");
      out.write("                                                    <label>\n");
      out.write("                                                        Producto Col:  <br>\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <input type=\"text\" name=\"textproductocol\"> \n");
      out.write("\n");
      out.write("                                                    <label>\n");
      out.write("                                                        Muestreo:  <br></label>\n");
      out.write("                                                    <input type=\"text\" name=\"textid_muestreo\"> \n");
      out.write("\n");
      out.write("                                                    <label>\n");
      out.write("                                                        Stock:</label>\n");
      out.write("                                                    <input type=\"text\" name=\"textunidades_existentes\"> \n");
      out.write("\n");
      out.write("                                                    <label>\n");
      out.write("                                                        Precio:  </label>\n");
      out.write("                                                    <input type=\"text\" name=\"textprecio\"> \n");
      out.write("\n");
      out.write("                                                    <button> Registrar\n");
      out.write("\n");
      out.write("                                                    </button>\n");
      out.write("                                                    <input type=\"hidden\" value=\"1\" name=\"opcion\" > ");
      out.write("\n");
      out.write("                                                </form>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div><!-- .animated -->\n");
      out.write("            </div><!-- .content -->\n");
      out.write("\n");
      out.write("            <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("            <footer class=\"site-footer\">\n");
      out.write("                <div class=\"footer-inner bg-white\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-6\">\n");
      out.write("                            Copyright &copy; 2021 LinAdmin\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-6 text-right\">\n");
      out.write("                            Diseñado por <a href=\"#\">LinAdmin</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("        </div><!-- /#right-panel -->\n");
      out.write("\n");
      out.write("        <!-- Right Panel -->\n");
      out.write("\n");
      out.write("        <!-- Scripts -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/main.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

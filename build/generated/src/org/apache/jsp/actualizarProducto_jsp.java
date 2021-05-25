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
import com.lina.vo.UsuariosVO;

public final class actualizarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
  //validamos si existe sesion, de lo contrario redirigimos al login
HttpSession misession= (HttpSession) request.getSession();
if(misession==null || misession.getAttribute("usuarioSesion")==null ){ 
    request.setAttribute("MensajeU", "¡No se encontro ninguna sesion activa por favor inicia nuevamente.!");
    request.getRequestDispatcher("Login.jsp").forward(request, response);
}
 UsuariosVO userSesion= (UsuariosVO) misession.getAttribute("usuarioSesion");

      out.write(" \r\n");
      out.write("<!doctype html>\r\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\" lang=\"\"> <!--<![endif]-->\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <title>Registrar Producto </title>\r\n");
      out.write("        <meta name=\"description\" content=\"Ela Admin - HTML5 Admin Template\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"colocarL\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/cs-skin-elastic.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/lib/datatable/dataTables.bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("        <link href=\"css/EstiloProdAc.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("        <!-- <script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js\"></script> -->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Left Panel -->\r\n");
      out.write("\r\n");
      out.write("        <aside id=\"left-panel\" class=\"left-panel\">\r\n");
      out.write("            <nav class=\"navbar navbar-expand-sm navbar-default\">\r\n");
      out.write("\r\n");
      out.write("                <div id=\"main-menu\" class=\"main-menu collapse navbar-collapse\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav\">\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"menu-title\">Menu</li><!-- /.menu-title -->\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"menu-item-has-children active dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-truck\"></i>Pedidos</a>\r\n");
      out.write("                            <ul class=\"sub-menu children dropdown-menu\">\r\n");
      out.write("                                 <li><i class=\"fa fa-table\"></i><a href=\"registrarProducto.jsp\">Registrar </a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"menu-item-has-children active dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-table\"></i>Productos</a>\r\n");
      out.write("                            <ul class=\"sub-menu children dropdown-menu\">\r\n");
      out.write("                                <li><i class=\"fa fa-table\"></i><a href=\"registrarProducto.jsp\">Registrar </a></li>\r\n");
      out.write("                                <li><i class=\"fa fa-table\"></i><a href=\"actualizarProducto.jsp\">Actualizar Y Eliminar </a></li>\r\n");
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div><!-- /.navbar-collapse -->\r\n");
      out.write("            </nav>\r\n");
      out.write("        </aside><!-- /#left-panel -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Left Panel -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Right Panel -->\r\n");
      out.write("        <div id=\"right-panel\" class=\"right-panel\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Header-->\r\n");
      out.write("            <header id=\"header\" class=\"header\">\r\n");
      out.write("                <div class=\"top-left\">\r\n");
      out.write("                    <div class=\"navbar-header\">\r\n");
      out.write("                        <a class=\"navbar-brand\" href=\"LinaHome.jsp\"><img src=\"Imagen/LogoLina.svg\" alt=\"Logo\"></a>\r\n");
      out.write("                        <a class=\"navbar-brand hidden\" href=\"./\"><img src=\"images/logo2.png\" alt=\"Logo\"></a>\r\n");
      out.write("                        <a id=\"menuToggle\" class=\"menutoggle\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"top-right\">\r\n");
      out.write("                    <div class=\"header-menu\">\r\n");
      out.write("                        <div class=\"header-left\">\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"user-area dropdown float-right\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle active\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                                <img class=\"user-avatar rounded-circle\" src=\"images/admin.jpg\" alt=\"User Avatar\">\r\n");
      out.write("                            </a>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"user-menu dropdown-menu\">\r\n");
      out.write("                                <a class=\"nav-link\" href=\"#\"><i class=\"fa fa-user\"></i>My Profile</a>\r\n");
      out.write("                                <a class=\"nav-link\" href=\"Login.jsp\"><i class=\"fa fa-power-off\"></i>Logout</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </header><!-- /header -->\r\n");
      out.write("            <!-- Header-->\r\n");
      out.write("            <div class=\"breadcrumbs\">\r\n");
      out.write("                <div class=\"breadcrumbs-inner\">\r\n");
      out.write("                    <div class=\"row m-0\">\r\n");
      out.write("                        <div class=\"col-sm-4\">\r\n");
      out.write("                            <div class=\"page-header float-left\">\r\n");
      out.write("                                <div class=\"page-title\">\r\n");
      out.write("                                    <h1>Registar Productos</h1>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-sm-8\">\r\n");
      out.write("                            <div class=\"page-header float-right\">\r\n");
      out.write("                                <div class=\"page-title\">\r\n");
      out.write("                                    <ol class=\"breadcrumb text-right\">\r\n");
      out.write("                                        <li><a href=\"#\">Menu</a></li>\r\n");
      out.write("                                        <li><a href=\"#\">Productos</a></li>\r\n");
      out.write("                                        <li class=\"active\">Registrar Productos</li>\r\n");
      out.write("                                    </ol>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <div class=\"animated fadeIn\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-12\">\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("                                <div class=\"card-header\">\r\n");
      out.write("                                    <strong class=\"card-title\">Actualizar</strong>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <table class=\"table\">\r\n");
      out.write("                                        <div class=\"contenedor\">\r\n");
      out.write("                                            <!-- agrupar contenido en bloques -->\r\n");
      out.write("                                            <!-- contenedor Informacion -->\r\n");
      out.write("                                            <div class=\"ContenedorFormulario\">\r\n");
      out.write("                                                <!-- contenedor formulario -->\r\n");
      out.write("                                                <!-- insertar logo -->\r\n");
      out.write("                                                <!-- dividir elementos en categorias, se asigna una clase para el elemento ejemplo h1 -->      \r\n");
      out.write("                                                ");

                                                    productoVO proVO = (productoVO) request.getAttribute("Datos Consultados"); //crear objeto asignandole un valor de una vez
                                                    //
                                                    if (proVO != null) {

                                                
      out.write("  \r\n");
      out.write("                                                <form method=\"post\" action=\"Productos\">\r\n");
      out.write("                                                    <label for=\"textid_producto\">\r\n");
      out.write("                                                        Código Producto:\r\n");
      out.write("                                                    </label>\r\n");
      out.write("                                                    <input readonly type=\"text\" name=\"textid_producto\" value=\"");
      out.print(proVO.getId_producto());
      out.write("\" >\r\n");
      out.write("                                                    <label for=\"textid_tipo_producto\">\r\n");
      out.write("                                                        Tipo de Producto:\r\n");
      out.write("                                                    </label>\r\n");
      out.write("\r\n");
      out.write("                                                    <input type=\"text\" name=\"textid_tipo_producto\" value=\"");
      out.print(proVO.getId_tipo_producto());
      out.write("\" >\r\n");
      out.write("\r\n");
      out.write("                                                    <!-- <select name=\"textid_tipo_producto\"><br> <br>\r\n");
      out.write("                                                       <option>Seleccione...</option> \r\n");
      out.write("                                                    ");
      out.write(" .\r\n");
      out.write("                                                    </select>  -->\r\n");
      out.write("\r\n");
      out.write("                                                    <label for=\"textid_categoria\">\r\n");
      out.write("                                                        Categoria:\r\n");
      out.write("                                                    </label> \r\n");
      out.write("\r\n");
      out.write("                                                    <input type=\"text\" name=\"textid_categoria\" value=\"");
      out.print(proVO.getId_categoria());
      out.write("\" >\r\n");
      out.write("                                                    <!--  <select name=\"textid_categoria\"><br> <br>\r\n");
      out.write("                                                        <option>Seleccione...</option> \r\n");
      out.write("                                                    ");
      out.write(" .\r\n");
      out.write("                                                    </select> -->\r\n");
      out.write("\r\n");
      out.write("                                                    <label for=\"nomProducto\">\r\n");
      out.write("                                                        Nombre Producto:\r\n");
      out.write("                                                    </label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"textnombre_producto\" value=\"");
      out.print(proVO.getNombre_producto());
      out.write("\" >\r\n");
      out.write("\r\n");
      out.write("                                                    <label for=\"plaMaq\">\r\n");
      out.write("                                                        Planta Maquilado : \r\n");
      out.write("                                                    </label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"textid_planta\" value=\"");
      out.print(proVO.getId_planta());
      out.write("\" >\r\n");
      out.write("\r\n");
      out.write("                                                    <label>\r\n");
      out.write("                                                        Peso:  <br>\r\n");
      out.write("                                                    </label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"textpeso\" value=\"");
      out.print(proVO.getPeso());
      out.write("\" >\r\n");
      out.write("\r\n");
      out.write("                                                    <label>\r\n");
      out.write("                                                        Imagen: <br>\r\n");
      out.write("                                                    </label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"texturl_imagen\" value=\"");
      out.print(proVO.getUrl_imagen());
      out.write("\" >   \r\n");
      out.write("                                                    <label>\r\n");
      out.write("                                                        Producto Col:  <br>\r\n");
      out.write("                                                    </label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"textproductocol\" value=\"");
      out.print(proVO.getProductocol());
      out.write("\" >  \r\n");
      out.write("\r\n");
      out.write("                                                    <label>\r\n");
      out.write("                                                        Muestreo:  <br></label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"textid_muestreo\" value=\"");
      out.print(proVO.getId_muestreo());
      out.write("\" >  \r\n");
      out.write("\r\n");
      out.write("                                                    <label>\r\n");
      out.write("                                                        Stock:</label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"textunidades_existentes\" value=\"");
      out.print(proVO.getUnidades_existentes());
      out.write("\" >   \r\n");
      out.write("\r\n");
      out.write("                                                    <label>\r\n");
      out.write("                                                        Precio:  </label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"textprecio\" value=\"");
      out.print(proVO.getPrecio());
      out.write("\" >\r\n");
      out.write("                                                    <button> Actualizar\r\n");
      out.write("\r\n");
      out.write("                                                    </button>\r\n");
      out.write("                                                    <input type=\"hidden\" value=\"2\" name=\"opcion\" > ");
      out.write("   \r\n");
      out.write("                                                </form>\r\n");
      out.write("                                                <div class=\"MensajeE\">\r\n");
      out.write("\r\n");
      out.write("                                                    ");

                                                        if (request.getAttribute("mensajeError") != null) {
                                                    
      out.write("\r\n");
      out.write("                                                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                                                    ");
} else {
      out.write("\r\n");
      out.write("                                                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                                                    ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                ");
}
                                                
      out.write("  \r\n");
      out.write("                                                <a href=\"registrarProducto.jsp\" >  <button class=\"btn1\" >Volver</button></a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>                                 \r\n");
      out.write("                                    </table> \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div><!-- .animated -->\r\n");
      out.write("        </div><!-- .content -->   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"clearfix\"></div>\r\n");
      out.write("        <footer class=\"site-footer\">\r\n");
      out.write("            <div class=\"footer-inner bg-white\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-sm-6\">\r\n");
      out.write("                        Copyright &copy; 2021 LinAdmin\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-6 text-right\">\r\n");
      out.write("                        Diseñado por <a href=\"#\">LinAdmin</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("    </div><!-- /#right-panel -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Right Panel -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Scripts -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

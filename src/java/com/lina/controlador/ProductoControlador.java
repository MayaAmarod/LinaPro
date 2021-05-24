/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.controlador;

import com.lina.modelo.ProductoDAO;
import com.lina.vo.productoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aamaya
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/Productos"})
public class ProductoControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      //27 borrar el try
       //28 cambiar url partens
       //se pone rojo, punto de interrupción para validar errores, debugg project
       int opcion = Integer.parseInt(request.getParameter("opcion")); //29 ej para enumerar o identificar las vistas   
       
        String id_producto = request.getParameter("textid_producto"); //get parametrer recoger dato de la vista
        String id_tipo_producto = request.getParameter("textid_tipo_producto");
        String id_categoria = request.getParameter("textid_categoria");
        String nombre_producto = request.getParameter("textnombre_producto");
        String id_planta = request.getParameter("textid_planta");
        String peso = request.getParameter("textpeso");
        String url_imagen = request.getParameter("texturl_imagen");
        String productocol = request.getParameter("textproductocol");
        String id_muestreo = request.getParameter("textid_muestreo");
        String unidades_existentes = request.getParameter("textunidades_existentes");
        String precio = request.getParameter("textprecio");
        
    //30.enviar datos al productoVO 
 
    productoVO proVO =new productoVO(id_producto, id_tipo_producto, id_categoria,
            nombre_producto, id_planta, peso, url_imagen,productocol,id_muestreo,
            unidades_existentes,precio); //instanciar el objeto para acceder a los constructores
     //se toma el que tiene las variables ya que se va a enviar datos al VO
    
        //31. instanciar el DAO que hace las operaciones con datos que estan en VO
     
        ProductoDAO proDAO = new ProductoDAO(proVO); // ya va lleno con los datos recogidos en proVO
        
        switch(opcion){
      //controlador recibe del DAO un verdadero o falso y responde a la vista   
         case 1: //agregar registro, case por metodos creados en el DAO
                
             if (proDAO.agregarRegistro()) { //si el metodo es verdadero se envia mensaje
                 request.setAttribute("mensajeExito", "El producto se registro correctamente");
                 //obtenga un atributo que se llama mensaje exito, (nombredelatributo, mensaje enviado)
             }else{
                 request.setAttribute("mensajeError", "El producto NO se registro correctamente");
             }
        //36. Redireccionar mensaje a la vista, cuando se estan mandando atributos
             
      request.getRequestDispatcher("LinaHome.jsp").forward(request, response);
         //forward  manejar peticiones request o response en el jsp para que reciba los mensajes    
             break;
             
                      case 2: //actualizar registro
                
             if (proDAO.actualizarRegistro()) { //si el metodo es verdadero se envia mensaje
                 request.setAttribute("mensajeExito", "El producto se actualizo correctamente");
                 request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
                 //obtenga un atributo que se llama mensaje exito, (nombredelatributo, mensaje enviado)
             }else{
                 request.setAttribute("mensajeError", "El producto NO se actualizo correctamente");
                 request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
             }
        //36. Redireccionar mensaje a la vista, cuando se estan mandando atributos
     
         //forward  manejar peticiones request o response en el jsp para que reciba los mensajes    
             break;
             //metodos personalizados
             
         case 3: //metodo propio

            proVO = proDAO.consultar_nombreProducto(id_producto); //se llena el objeto con la consulta que se hace en dao

             if (proVO != null) { //si retorna no nulo significa que si lleno 
                 request.setAttribute("Datos Consultados", proVO); //el objeto se llama datos consultados, se envia VO lleno
                 request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response); //aqui va a llenar
                 //si va a actualizar luego de la consulta o solo ver
             }else{
                  request.setAttribute("mensajeError", "El producto NO existe");
                  request.getRequestDispatcher("consultarProducto.jsp").forward(request, response); 
             }
             break;
             //37 VISTAS WEB PAGES, Nuevo jsp  
             //38. nuevo java class categoriaVO, despues, para crear foraneas
     } 
        
        
        
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

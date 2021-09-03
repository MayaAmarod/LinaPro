
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.controlador;

import com.lina.modelo.PedidoDAO;
import com.lina.modelo.ProductoDAO;
import com.lina.vo.PedidoVO;
import com.lina.vo.productoVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author neherrera0@misena.edu.co  
 */
@WebServlet(name = "RealizarPedidoControlador", urlPatterns = {"/RealizarPedidoControlador"})
public class RealizarPedidoControlador extends HttpServlet {

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
        String opcion = request.getParameter("opcion");

        if ("confirmar_pedido".equals(opcion)) {
            confirmarPedido(request, response);
        }

        if ("detalle_pedido".equals(opcion)) {
            detallePedido(request, response);
        }
    }

    public void confirmarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //guardamos los datos del pedido
        int id_Usuario = Integer.parseInt(request.getParameter("textid_usuario"));
        Date fecha_Pedido = new Date(Calendar.getInstance().getTime().getTime());// colocamos la fecha en que se realiza el pedido
        Date fecha_Entrega = Date.valueOf(request.getParameter("textfecha_entrega"));
        String forma_Envio = request.getParameter("textforma_envio");
        PedidoVO pedVO = new PedidoVO(0, id_Usuario, fecha_Pedido, fecha_Entrega, forma_Envio,"Nuevo");

        //guardamos en cestaDeproductosSeleccionados los productos seleccionados con cantidad y subtotal
        ProductoDAO proDAO = new ProductoDAO();
        Double precioTotalPedido = 0.0;
        List<productoVO> cestaDeproductosSeleccionados = new ArrayList<productoVO>();
        List<productoVO> listaProductosDb = proDAO.listar();
        for (productoVO producto : listaProductosDb) {
            if (request.getParameter("cantidad_" + producto.getId_producto()) != null) {
                int cantidadSeleccionada = Integer.parseInt(request.getParameter("cantidad_" + producto.getId_producto()));
                if (cantidadSeleccionada != 0) {//si selecciono mas de una unidad lo añadimos a la cesta
                    Double subtotal = Double.parseDouble(producto.getPrecio()) * cantidadSeleccionada;
                    producto.setSubtotal(subtotal);
                    producto.setCantidadAComprar(cantidadSeleccionada);
                    cestaDeproductosSeleccionados.add(producto);
                    precioTotalPedido += subtotal;
                }
            }
        }
        if (precioTotalPedido < 1) {
            request.setAttribute("mensajeError", "Debe seleccionar por lo menos una unidad de un producto");
            request.getRequestDispatcher("RealizarPedidos.jsp").forward(request, response);
        } else {
            //guardamos los valores en el request y redireccionamos a ConfirmarPedido.jsp
            request.setAttribute("Pedido", pedVO);
            request.setAttribute("cestaDeproductosSeleccionados", cestaDeproductosSeleccionados);
            request.setAttribute("precioTotalPedido", precioTotalPedido);
             request.setAttribute("opcion", "confirmar_pedido");
            request.getSession().setAttribute("Pedido", pedVO);
            request.getSession().setAttribute("cestaDeproductosSeleccionados", cestaDeproductosSeleccionados);
            request.getSession().setAttribute("precioTotalPedido", precioTotalPedido);
            request.getRequestDispatcher("ConfirmarPedido.jsp").forward(request, response);

        }
    }

    public void detallePedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traemos la informacion del pedido
        int idPedido = Integer.parseInt(request.getParameter("textid_pedido"));
        PedidoDAO pedidoDao = new PedidoDAO();
        PedidoVO pedVO = pedidoDao.obtenerPedidoPorId(idPedido);

        //traemos los productos del pedido
        ProductoDAO proDAO = new ProductoDAO();
        Double precioTotalPedido = 0.0;
        List<productoVO> cestaDeproductosSeleccionados = proDAO.listarProductosPorPedido(idPedido);
        for (productoVO producto : cestaDeproductosSeleccionados) {
            precioTotalPedido += producto.getSubtotal();
        }
        request.setAttribute("Pedido", pedVO);
        request.setAttribute("cestaDeproductosSeleccionados", cestaDeproductosSeleccionados);
        request.setAttribute("precioTotalPedido", precioTotalPedido);
           request.setAttribute("opcion", "detalle_pedido");
        request.getSession().setAttribute("Pedido", pedVO);
        request.getSession().setAttribute("cestaDeproductosSeleccionados", cestaDeproductosSeleccionados);
        request.getSession().setAttribute("precioTotalPedido", precioTotalPedido);
        request.getRequestDispatcher("ConfirmarPedido.jsp").forward(request, response);
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
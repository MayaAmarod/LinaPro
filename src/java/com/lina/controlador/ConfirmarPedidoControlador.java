
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.controlador;

import com.lina.modelo.DetallePedidoDao;
import com.lina.modelo.PedidoDAO;
import com.lina.vo.PedidoVO;
import com.lina.vo.productoVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nidia herrera
 */
@WebServlet(name = "ConfirmarPedidoControlador", urlPatterns = {"/ConfirmarPedidoControlador"})
public class ConfirmarPedidoControlador extends HttpServlet {

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
        try {
            //tomamos los valores del pedido y sus productos
            HttpSession misession = (HttpSession) request.getSession();
            List<productoVO> cestaDeproductosSeleccionados = (List<productoVO>) misession.getAttribute("cestaDeproductosSeleccionados");
            PedidoVO pedVO = (PedidoVO) misession.getAttribute("Pedido");
            Double precioTotalPedido = (Double) misession.getAttribute("precioTotalPedido");

            //guardamos el nuevo pedido y recuperamos su id
            PedidoDAO pedidoDao = new PedidoDAO();
            pedidoDao.agregarRegistro(pedVO);
            pedidoDao = new PedidoDAO();
            PedidoVO ultimoPedVO = pedidoDao.obtenerUltimoPedidoGuardado();

            //guardamos productos del nuevo pedido
            DetallePedidoDao DetallePedidoDao = new DetallePedidoDao();
            for (productoVO producto : cestaDeproductosSeleccionados) {
                int idPedido = ultimoPedVO.getId_Pedido();
                int idProducto = Integer.parseInt(producto.getId_producto());
                Double subTotal = producto.getSubtotal();
                int cantidad = producto.getCantidadAComprar();
                DetallePedidoDao.agregarProductoAPedido(idPedido, idProducto, subTotal, cantidad);
                DetallePedidoDao = new DetallePedidoDao();
            }

            //retornamos a detalle prdido
            request.setAttribute("mensajeExito", "Pedido generado exitosamente! Nuevo Pedido #: "+ultimoPedVO.getId_Pedido());
            request.getRequestDispatcher("detallePedidos.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensajeError", "Error al guardar el pedido: "+e.getMessage());
            request.getRequestDispatcher("ConfirmarPedido.jsp").forward(request, response);
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
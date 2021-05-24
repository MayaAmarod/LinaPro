/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.controlador;

import com.lina.modelo.PedidoDAO;
import com.lina.vo.PedidoVO;
import java.io.IOException;
import java.sql.Date;


import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nidia
 */
@WebServlet(name = "PedidoControlador", urlPatterns = {"/Pedido"})
public class PedidoControlador extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        int id_Usuario = Integer.parseInt(request.getParameter("textid_usuario"));
        Date fecha_Pedido=Date.valueOf(request.getParameter("textfecha_pedido"));
        Date fecha_Entrega=Date.valueOf(request.getParameter("textfecha_entrega"));
        String forma_Envio = request.getParameter("textforma_envio");

        PedidoVO pedVO = new PedidoVO(0, id_Usuario, fecha_Pedido, fecha_Entrega, forma_Envio);

        PedidoDAO pedDAO = new PedidoDAO();
        switch (opcion) {
            case 1:
                if (pedDAO.agregarRegistro(pedVO)) {
                    request.setAttribute("mensajeExito", "El pedido se registro correctamente");
                    request.getRequestDispatcher("detallePedidos.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El pedido NO se registro correctamente");
                }
                request.getRequestDispatcher("detallePedidos.jsp").forward(request, response);
                break;
            case 2:

                if (pedDAO.actualizarRegistro(pedVO)) {
                    request.setAttribute("mensajeExito", "El pedido se actualizo correctamente");

                } else {
                    request.setAttribute("mensajeError", "El pedido NO se actualizo correctamente");
                }

                request.getRequestDispatcher("actualizarPedido.jsp").forward(request, response);

                break;

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

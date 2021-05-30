
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.vo.PedidoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nidia Herrera
 */
public class DetallePedidoDao extends Conexion  {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    public boolean operacion = false;
    public String sql;

    public DetallePedidoDao() {
        try {
            conexion = this.obtenerConexion();
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
     public boolean agregarProductoAPedido(int idPedido,int idProducto,Double subTotal,int cantidad) {

        try {

            sql = "insert into detalle_pedido(id_pedido,id_producto,estado_pedido,cantidad_pedido,cantidad) values (?,?,'',?,?)";

            puente = conexion.prepareStatement(sql);
            puente.setInt(1, idPedido);
            puente.setInt(2, idProducto);
            puente.setDouble(3, subTotal);
             puente.setInt(4, cantidad);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;//retorna ya que es un método booleano 
    }
}
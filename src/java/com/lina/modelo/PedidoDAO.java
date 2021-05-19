/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.util.Crud;
import com.lina.vo.PedidoVO;
import com.lina.vo.productoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nidia
 */
public class PedidoDAO extends Conexion  {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    public boolean operacion = false;
    public String sql;

    public PedidoDAO() {
        try {
            conexion = this.obtenerConexion();
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public PedidoDAO(PedidoVO pedVO) {

        super();

    }


    public boolean agregarRegistro(PedidoVO pedVO) {

        try {

            sql = "insert into pedido(id_usuario,fecha_pedido,fecha_entrega,forma_envio) values (?,?,?,?)";

            puente = conexion.prepareStatement(sql);
            puente.setInt(1, pedVO.getId_Usuario());
            puente.setDate(2, pedVO.getFecha_Pedido());
            puente.setDate(3, pedVO.getFecha_Entrega());
            puente.setString(4, pedVO.getForma_Envio());
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


    public boolean actualizarRegistro(PedidoVO pedVO) {
        try {
            sql = "update pedido set id_usuario=?, "
                    + "fecha_pedido=?, fecha_entrega=?,"
                    + " forma_envio=? where id_pedido=?";

            puente = conexion.prepareStatement(sql);

           puente.setInt(1, pedVO.getId_Usuario());
            puente.setDate(2, pedVO.getFecha_Pedido());
            puente.setDate(3, pedVO.getFecha_Entrega());
            puente.setString(4, pedVO.getForma_Envio());
           puente.setInt(5, pedVO.getId_Pedido());
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
        return operacion;

    }

   

    public ArrayList<PedidoVO> listar() {
        PedidoVO pedVo = null;
        ArrayList<PedidoVO> listaPedidos = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();

            sql = "select * from pedido"; //query
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                pedVo = new PedidoVO(mensajero.getInt(1), mensajero.getInt(2),
                        mensajero.getDate(3), mensajero.getDate(4),
                        mensajero.getString(5));

                listaPedidos.add(pedVo);

            }

        } catch (SQLException e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return listaPedidos;
    }
}

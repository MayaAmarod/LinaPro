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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public PedidoVO obtenerUltimoPedidoGuardado() {
        PedidoVO pedVo = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from pedido where id_pedido=(select max(id_pedido) from pedido)"; //query
           
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
             
            while (mensajero.next()) {
                pedVo = new PedidoVO(mensajero.getInt(1), mensajero.getInt(2),
                        mensajero.getDate(3), mensajero.getDate(4),
                        mensajero.getString(5),mensajero.getString(6));
                pedVo.setNombreUsuario(mensajero.getString("nombre"));
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
        return pedVo;
    }
    
    
     public int getNumeroPedidosHoy() {
        int resultado=0;
        try {
            conexion = this.obtenerConexion();
            Date hoy = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            sql = "select id_pedido from pedido where fecha_pedido=?"; //query
           
            puente = conexion.prepareStatement(sql);
             puente.setDate(1, hoy);
            mensajero = puente.executeQuery();
             
            while (mensajero.next()) {
              resultado++;
            }
        } catch (SQLException e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
               // this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return resultado;
    }
     
      public int getNumeroMaximoPedidos() {
        int resultado=0;
        try {
            conexion = this.obtenerConexion();
            sql = "select nuumero_pedidos_maximos from configuracion"; //query
           
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
             
            while (mensajero.next()) {
              resultado=mensajero.getInt(1);
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
        return resultado;
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
        return operacion;//retorna ya que es un m??todo booleano 
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
    
     public boolean actualizarEstado(int idPedido, String nuevoEstado) {
        try {
            sql = "update pedido set estado_pedido=? "
                    + " where id_pedido=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nuevoEstado);
           puente.setInt(2, idPedido);
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
                        mensajero.getString(5),mensajero.getString(6));
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
    
     public PedidoVO obtenerPedidoPorId(int idPedido) {
        PedidoVO pedVo = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from pedido where id_pedido=?"; //query
           
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, idPedido);
            mensajero = puente.executeQuery();
             
            while (mensajero.next()) {
                pedVo = new PedidoVO(mensajero.getInt(1), mensajero.getInt(2),
                        mensajero.getDate(3), mensajero.getDate(4),
                        mensajero.getString(5),mensajero.getString(6));
                pedVo.setNombreUsuario(mensajero.getString("nombre"));
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
        return pedVo;
    }
    
    
     public ArrayList<PedidoVO> listarPedidosConNombreUsuario() {
        PedidoVO pedVo = null;
        ArrayList<PedidoVO> listaPedidos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select p.id_pedido,p.id_usuario , p.fecha_pedido, p.fecha_entrega, p.forma_envio, u.nombre, p.estado_pedido"+
                    " from pedido p "+
                    "inner join usuario u on p.id_usuario=u.id_usuario"; //query
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                pedVo = new PedidoVO(mensajero.getInt(1), mensajero.getInt(2),
                        mensajero.getDate(3), mensajero.getDate(4),
                        mensajero.getString(5),mensajero.getString(7));
                pedVo.setNombreUsuario(mensajero.getString("nombre"));
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

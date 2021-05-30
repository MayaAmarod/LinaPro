/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.vo.CategoriaProductoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aamaya
 */
public class CategoriaProductoDAO extends Conexion {
    
    //Extends para heredar la coenxión a base de datos 
    private Connection conexion; //establecer conexion
    private PreparedStatement puente; // crea puente a la conexion para enviar las sentencias
    private ResultSet mensajero; // cuando se hace una consulta 

    //5. declarar variables
    public boolean operacion = false; //se utiliza para almacenar el resultado de la operación SQL
    public String sql; //donde se van a guardar las sentencias de DB
    
public ArrayList<CategoriaProductoVO> listar() {  // ALMACENAR objetos VO, lo almacena en posiciones
        //se puede listar directamente en jsp y no en controlador ya que no pide datos

        CategoriaProductoVO catProVo = null; //declarar VO
        ArrayList<CategoriaProductoVO> listaCategorias = new ArrayList<>(); //crear arraylist        

        try {
            conexion = this.obtenerConexion();

            sql = "select * from categoria_producto"; //query
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                catProVo = new CategoriaProductoVO(mensajero.getString(1)
                           , mensajero.getString(2), mensajero.getString(3));

                listaCategorias.add(catProVo); //lo agrega a la posicion del arreglo hasta que ya no encuentre

            }

        } catch (SQLException e) {
            Logger.getLogger(CategoriaProductoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion(); // independiente que pase en try catch haga finally
            } catch (Exception e) {

                Logger.getLogger(CategoriaProductoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return listaCategorias;
    }

//metodo guardar dato string y no value en db
public String consultarNombreCategoria(String id){
    String nombreCategoria=null;
    
     try {
            conexion = this.obtenerConexion();

            sql = "SELECT * FROM categoria_producto WHERE id_categoria=?;"; //query
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id); //enviar en el primer ? el id que se recibe
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                nombreCategoria = mensajero.getString(2); //asignar lo que el mensajero encuentre, valor columa 2
            }

        } catch (SQLException e) {
            Logger.getLogger(CategoriaProductoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
//            try {
//                this.cerrarConexion(); // no se puede cerrar porque consulta varias veces
//            } catch (Exception e) {
//
//                Logger.getLogger(CategoriaProductoDAO.class.getName()).log(Level.SEVERE, null, e);
//
//            }
        }
        return nombreCategoria;
}
}

//directo a jsp
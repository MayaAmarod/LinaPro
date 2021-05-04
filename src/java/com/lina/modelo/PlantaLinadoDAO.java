/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.vo.CategoriaProductoVO;
import com.lina.vo.PlantaLinadoVO;
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
public class PlantaLinadoDAO extends Conexion{
    
 //Extends para heredar la coenxión a base de datos 
    private Connection conexion; //establecer conexion
    private PreparedStatement puente; // crea puente a la conexion para enviar las sentencias
    private ResultSet mensajero; // cuando se hace una consulta 

    //5. declarar variables
    public boolean operacion = false; //se utiliza para almacenar el resultado de la operación SQL
    public String sql; //donde se van a guardar las sentencias de DB
    
public ArrayList<PlantaLinadoVO> listar() {  // ALMACENAR objetos VO, lo almacena en posiciones
        //se puede listar directamente en jsp y no en controlador ya que no pide datos

        PlantaLinadoVO plaLinVo = null; //declarar VO
        ArrayList<PlantaLinadoVO> listaPlantas = new ArrayList<>(); //crear arraylist        

        try {
            conexion = this.obtenerConexion();

            sql = "select * from planta_linado"; //query
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                plaLinVo = new PlantaLinadoVO(mensajero.getString(1)
                           , mensajero.getString(2), mensajero.getString(3)
                , mensajero.getString(4), mensajero.getString(5));

                listaPlantas.add(plaLinVo); //lo agrega a la posicion del arreglo hasta que ya no encuentre

            }

        } catch (SQLException e) {
            Logger.getLogger(PlantaLinadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion(); // independiente que pase en try catch haga finally
            } catch (Exception e) {

                Logger.getLogger(PlantaLinadoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return listaPlantas;
    }

}

//directo a jsp
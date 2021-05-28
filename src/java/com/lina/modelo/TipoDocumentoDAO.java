/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.vo.TipoDocumentoVO;
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
public class TipoDocumentoDAO extends Conexion{
    
     //Extends para heredar la coenxión a base de datos 
    private Connection conexion; //establecer conexion
    private PreparedStatement puente; // crea puente a la conexion para enviar las sentencias
    private ResultSet mensajero; // cuando se hace una consulta 

    //5. declarar variables
    public boolean operacion = false; //se utiliza para almacenar el resultado de la operación SQL
    public String sql; //donde se van a guardar las sentencias de DB
    
    
    public ArrayList<TipoDocumentoVO> listar() {  // ALMACENAR objetos VO, lo almacena en posiciones
        //se puede listar directamente en jsp y no en controlador ya que no pide datos

        TipoDocumentoVO tipoDocVo = null; //declarar VO
        ArrayList<TipoDocumentoVO> listaTipoDoc = new ArrayList<>(); //crear arraylist        

        try {
            conexion = this.obtenerConexion();

            sql = "select * from tipo_documento"; //query
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                tipoDocVo = new TipoDocumentoVO(mensajero.getString(1), mensajero.getString(2));

                listaTipoDoc.add(tipoDocVo); //lo agrega a la posicion del arreglo hasta que ya no encuentre

            }

        } catch (SQLException e) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion(); // independiente que pase en try catch haga finally
            } catch (Exception e) {

                Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return listaTipoDoc;
    }

}

//directo a jsp
    

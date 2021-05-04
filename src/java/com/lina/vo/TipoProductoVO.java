/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.vo;

/**
 *
 * @author aamaya
 */
public class TipoProductoVO {

    private String id_tipo_producto, nombre_tipo;

          //generar constructor vacio, no va a recibir sino enviar
    
        public TipoProductoVO() {
    }
        
         public TipoProductoVO(String id_tipo_producto, String nombre_tipo) {
        this.id_tipo_producto = id_tipo_producto;
        this.nombre_tipo = nombre_tipo;
    }  
    
        
    public String getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(String id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    //declarar variables
    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }
 
}

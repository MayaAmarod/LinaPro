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
public class CategoriaProductoVO {



    //declarar variables



    private String id_categoria, nombre_categoria, descripcion_categoria;

        //generar constructor vacio, no va a recibir sino enviar
    
        public CategoriaProductoVO() {
    }
        public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }
        public CategoriaProductoVO(String id_categoria, String nombre_categoria, String descripcion_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.descripcion_categoria = descripcion_categoria;
    }
    
        public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }


}
//dao
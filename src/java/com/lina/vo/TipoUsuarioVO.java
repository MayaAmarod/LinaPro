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
public class TipoUsuarioVO {

  
    private String id_tipo_usuario, nombre_tipo_usuario;
    
     //generar constructor vacio, no va a recibir sino enviar
    
        public TipoUsuarioVO() {
    }
            public TipoUsuarioVO(String id_tipo_usuario, String nombre_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }
            
                public String getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(String id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }        
        
}

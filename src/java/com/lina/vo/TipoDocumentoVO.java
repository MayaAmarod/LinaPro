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
public class TipoDocumentoVO {
 //declarar variables
    private String id_tipo_Documento, nombre_Documento;
    
        //generar constructor vacio, no va a recibir sino enviar
        public TipoDocumentoVO() {
    }
        
            public TipoDocumentoVO(String id_tipo_Documento, String nombre_Documento) {
        this.id_tipo_Documento = id_tipo_Documento;
        this.nombre_Documento = nombre_Documento;
    } 
            
                public String getId_tipo_Documento() {
        return id_tipo_Documento;
    }

    public void setId_tipo_Documento(String id_tipo_Documento) {
        this.id_tipo_Documento = id_tipo_Documento;
    }

    public String getNombre_Documento() {
        return nombre_Documento;
    }

   
    public void setNombre_Documento(String nombre_Documento) {
        this.nombre_Documento = nombre_Documento;
    }
}

//dao
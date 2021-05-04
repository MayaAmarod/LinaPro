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
public class PlantaLinadoVO {

    //declarar variables
    public void setCantidad_empacada(String cantidad_empacada) {
        this.cantidad_empacada = cantidad_empacada;
    }
    private String id_planta, fecha_ingreso, fecha_salida,numero_operarios,
            cantidad_empacada;

        //generar constructor vacio, no va a recibir sino enviar
        public PlantaLinadoVO() {
    }
        
         public PlantaLinadoVO(String id_planta, String fecha_ingreso, String fecha_salida, String numero_operarios, String cantidad_empacada) {
        this.id_planta = id_planta;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.numero_operarios = numero_operarios;
        this.cantidad_empacada = cantidad_empacada;
    }   
    
       public String getId_planta() {
        return id_planta;
    }

    public void setId_planta(String id_planta) {
        this.id_planta = id_planta;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getNumero_operarios() {
        return numero_operarios;
    }

    public void setNumero_operarios(String numero_operarios) {
        this.numero_operarios = numero_operarios;
    }

    public String getCantidad_empacada() {
        return cantidad_empacada;
    } 
}

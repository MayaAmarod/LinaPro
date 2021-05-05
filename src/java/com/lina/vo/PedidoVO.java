/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.vo;

/**
 *
 * @author Nidia
 */
public class PedidoVO {

    //Mensaje Jose Nidia github
    
    private String id_Pedido, id_Usuario, fecha_Pedido,
            fecha_Entrega, forma_Envio;
    
    public PedidoVO() {
    }
    
    public PedidoVO(String id_Pedido, String id_Usuario, String fecha_Pedido, String fecha_Entrega, String forma_Envio) {
        this.id_Pedido = id_Pedido;
        this.id_Usuario = id_Usuario;
        this.fecha_Pedido = fecha_Pedido;
        this.fecha_Entrega = fecha_Entrega;
        this.forma_Envio = forma_Envio;
    }

   

    public String getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(String id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getFecha_Pedido() {
        return fecha_Pedido;
    }

    public void setFecha_Pedido(String fecha_Pedido) {
        this.fecha_Pedido = fecha_Pedido;
    }

    public String getFecha_Entrega() {
        return fecha_Entrega;
    }

    public void setFecha_Entrega(String fecha_Entrega) {
        this.fecha_Entrega = fecha_Entrega;
    }

    public String getForma_Envio() {
        return forma_Envio;
    }

    public void setForma_Envio(String forma_Envio) {
        this.forma_Envio = forma_Envio;
    }

    
    
}

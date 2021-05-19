/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.vo;

import java.sql.Date;

/**
 *
 * @author Nidia
 */
public class PedidoVO {

    //Mensaje Jose Nidia github
    private int id_Pedido, id_Usuario;
    private String forma_Envio;
    private Date fecha_Pedido, fecha_Entrega;

    public PedidoVO() {
    }

    public PedidoVO(int id_Pedido, int id_Usuario, Date fecha_Pedido, Date fecha_Entrega, String forma_Envio) {
        this.id_Pedido = id_Pedido;
        this.id_Usuario = id_Usuario;
        this.forma_Envio = forma_Envio;
        this.fecha_Pedido = fecha_Pedido;
        this.fecha_Entrega = fecha_Entrega;
    }

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getForma_Envio() {
        return forma_Envio;
    }

    public void setForma_Envio(String forma_Envio) {
        this.forma_Envio = forma_Envio;
    }

    public Date getFecha_Pedido() {
        return fecha_Pedido;
    }

    public void setFecha_Pedido(Date fecha_Pedido) {
        this.fecha_Pedido = fecha_Pedido;
    }

    public Date getFecha_Entrega() {
        return fecha_Entrega;
    }

    public void setFecha_Entrega(Date fecha_Entrega) {
        this.fecha_Entrega = fecha_Entrega;
    }

}

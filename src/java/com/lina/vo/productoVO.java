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
public class productoVO {
    
        //14.  definir variables
    //recoger datos como cadena y se convierte cuando se vaya a mostrar o siempre string si no se va a operar
    //definir buenos nombres en la base de datos para poder declarar las variables igual
    public void setPrecio(String precio) {
        this.precio = precio;
    }
   
private String id_producto, id_tipo_producto, id_categoria, nombre_producto, 
                id_planta, peso,url_imagen,productocol,id_muestreo,
                unidades_existentes,precio;
//privadas, el constructor las vuelve publicas para el uso de get and set
    
  //15. crear constructor clic derecho, insertar codigo, constructor, seleccionar variables
   // constructor, crear metodo para recibir variables 
        public productoVO(String id_producto, String id_tipo_producto, String id_categoria, String nombre_producto, String id_planta, String peso, String url_imagen, String productocol, String id_muestreo, String unidades_existentes, String precio) {
        this.id_producto = id_producto;
        this.id_tipo_producto = id_tipo_producto;
        this.id_categoria = id_categoria;
        this.nombre_producto = nombre_producto;
        this.id_planta = id_planta;
        this.peso = peso;
        this.url_imagen = url_imagen;
        this.productocol = productocol;
        this.id_muestreo = id_muestreo;
        this.unidades_existentes = unidades_existentes;
        this.precio = precio;
    }

   //16. constructor vacio, no seleccionar ninguno
   //cuando el VO no reciba datos sino solo envia (set) utiliza el vacio
   //lleno si obtener datos(get)consultar  o listar
    public productoVO() {
    }

   //17. generar getter an setter, seleccionar variables todas
            
public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(String id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getId_planta() {
        return id_planta;
    }

    public void setId_planta(String id_planta) {
        this.id_planta = id_planta;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getProductocol() {
        return productocol;
    }

    public void setProductocol(String productocol) {
        this.productocol = productocol;
    }

    public String getId_muestreo() {
        return id_muestreo;
    }

    public void setId_muestreo(String id_muestreo) {
        this.id_muestreo = id_muestreo;
    }

    public String getUnidades_existentes() {
        return unidades_existentes;
    }

    public void setUnidades_existentes(String unidades_existentes) {
        this.unidades_existentes = unidades_existentes;
    }

    public String getPrecio() {
        return precio;
    }

//18.hacer DAO, nuevo paquete, modelo DAO, Nuevo Java CLASS, 
//que hara las operaciones del sistema
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.util;

/**
 *
 * @author aamaya
 */
public interface Crud {

//12 crear metodos abstractos que se llaman y se pueden rellenar como una plantilla en otras clases
    //se generan vacios ej Crud estos metodos son en comun para todos los DAO
    //boolean devuelve true si pudo o false si no
    //abstracion definir algo para despues llamarlo y obtenerlo    
    public abstract boolean agregarRegistro(); //create

    public abstract boolean actualizarRegistro(); //update
    //  public abstract boolean eliminarRegistro(); delete por seguridad no se usa delete directo
    //es actualizar y se crean un estado inactivo en las tablas , crear una columna estado en ls tablas de db 
    //   public abstract boolean consultarRegistro(); read solo si es igual en todos los modulos
}

//13.hacer VO, nuevo paquete, modelo VO, Nuevo Java CLASS, 
//se crea para elementos que se van a utilizar en el modulo
//con el nombre del modulo, EJ UsuarioVO

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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author aamaya
 */
public class Conexion {
//1. conectar base de datos, mysql,
//prestacion, nueva conexión  base de datos
// mysql connector
//nombre de la base de datos, test de conexion y finalizar.

//2. proyecto nuevo java web aplication
//servidor glash fish permite interpretar el codigo al navegador
    
//3.se agrega nuevo paquete  (sirve para manejar la seguridad o control de acceso)
//paquete util, donde esta la conexión de DB y Crud que sirven en el proyecto en general
//nueva java class en el paquete util, conexion para db
    
//4.declarar variables para conectarse a la base de datos 
// lo que necesitamos para conectarnos    
    public String classname, user, password, bd, urlBd; 
    
//5. se requieren 3 elementos para conectarse a la base de datos, puerta, puente, mensajero    
//puerta de tipo connection    
//public connection conexion;
//en el bombillo agregar java.sql.connection;    
    public Connection conexion;

//6.declarar metodo principal de la clase que apenas se abre se ejecuta
//unico metodo que se llama igual a la clase y que va en mayuscula
    
    public Conexion() {
//7. asignar valores 
        classname = "com.mysql.jdbc.Driver"; // conectarse al Driver, se obtiene en prestaciones propiedades de DB
        user = "linadmin"; //este usuario y clave deben cambiarse, en privilegios del motor de db
        password = "Uigjb27WP+]uv*d";
        bd = "lina"; //base de datos cargada
        urlBd = "jdbc:mysql://localhost:3306/" + bd; //url de base de datos

//8. establecer conexión 
        try {
            //cree una nueva instancia para traer el driver
            Class.forName(classname).newInstance(); 
            //en la variable conexión obtener el acceso a la db
            //importar en el bombillo permite obtener la conexion el DriverManager
            conexion = DriverManager.getConnection(urlBd, user, password);
            System.out.println("Conexión Exitosa");
        } catch (Exception e) {
            //e.tostring para que muestre el error o excepcion, el sistema lo valida e imprime
            System.out.println("Error al conectarse" + e.toString()); 
        }

    }
   //9.metodo publico tipo Connection objeto que retorna la conexion
    public Connection obtenerConexion() { 
   // se retorna la conexion establecida a la base de datos, es la variable     
        return conexion;  

    }
    //10. metodo publico tipo Connection para cerrar
    public Connection cerrarConexion() throws SQLException {
        //pára usar close agregar clausula throws SQLException en caso de que no se pueda cerrar notifica el error
        //bd atomicidad se hace completamente o no se hace
        conexion.close();
        conexion = null;
        return conexion; // retorna cerrar y nula 
    }
    
    //11.  crear interface en util 
    //nuevo, otro, java, java interface en paquete util Crud
    
//    public static void main(String[] args) {
//        new Conexion();
////        Error al conectarsejava.lang.ClassNotFoundException: com.mysql.jdbc.Driver
////                Enn librerias cargar DriverMySQL jdbc - se ejecuta para probar si esta conectando a la DB
////    
//    }
}

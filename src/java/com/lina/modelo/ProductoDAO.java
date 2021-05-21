/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.util.Crud;
import com.lina.vo.productoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aamaya
 */
public class ProductoDAO extends Conexion implements Crud {

    //4. DECLARAR objetos
    // definir los elementos que se necesitan para conectarse y hacer  operaciones de base de datos
    // son 3 conexion, puente  y mensajero
    private Connection conexion; //establecer conexion
    private PreparedStatement puente; // crea puente a la conexion para enviar las sentencias
    private ResultSet mensajero; // cuando se hace una consulta 

    //5. declarar variables
    public boolean operacion = false; //se utiliza para almacenar el resultado de la operación SQL
    public String sql; //donde se van a guardar las sentencias de DB   

    //6. declarar variables que haran operaciones, las mismas del VO
    public ProductoDAO() {
    }
    private String id_producto = "", id_tipo_producto = "", id_categoria = "",
            nombre_producto = "", id_planta = "", peso = "", url_imagen = "",
            productocol = "", id_muestreo = "", unidades_existentes = "", precio = "";
    //  se inicializan en vacio por si alguno llega nulo

    //7. se llama igual a la clase principal, metodo principal traer datos el VO
    //se crea en la clase principal porque se establece conexión que es lo primero que debe hacer 
    public ProductoDAO(productoVO proVO) {
        //parametro para llenar con los que estan en VO,agregar import ya que esta en otro paquete

        //8.public class ProductoDAO extends Conexion { 
        //heredar clase conexión para obtener metodos obtenerconexion() cerrarconexion() 
        //(productoVO proVO) Apodo proVO para generar la herencia e instanciar
        super(); // se usa super se traen variables de una superClase, ya que no se puede hacer doble herencia

        //9. try
        try {
            conexion = this.obtenerConexion(); //10.extends Conexion heredar conexion 

            //11. traer valores que estan en el VO
            id_producto = proVO.getId_producto(); //en la varible declarada aqui , obtener valor que esta en vehVO
            id_tipo_producto = proVO.getId_tipo_producto();
            id_categoria = proVO.getId_categoria();
            nombre_producto = proVO.getNombre_producto();
            id_planta = proVO.getId_planta();
            peso = proVO.getPeso();
            url_imagen = proVO.getUrl_imagen();
            productocol = proVO.getProductocol();
            id_muestreo = proVO.getId_muestreo();
            unidades_existentes = proVO.getUnidades_existentes();
            precio = proVO.getPrecio();

        } catch (Exception e) {
            //12 excepciones, agregar libreria logging
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            //obtener log del error de la clase y categorizar
        }
    }

    //13. en la clase principal agregar implements Crud, para agregar los metodos genericos o abstractos
    //public class Productodao extends Conexion implements Crud
    //boton derecho agregar todos los metodos abstractos en el bombillo
    @Override
    public boolean agregarRegistro() {

        try {
            //14 agregar sentencia SQL       
            sql = "insert into producto(id_tipo_producto,id_categoria,"
                    + "nombre_producto,id_planta,peso,url_imagen,productocol,"
                    + "id_muestreo,unidades_existentes,precio) values (?,?,?,?,?,?,?,?,?,?)";

            //no se indican las columnas ya que se van a diligenciar todos los datos, 
            //si hubiera algun autoincrementable si especificar columnas
            //? viene un parametro pero no se conoce cual es, para que no sea vulnerable a inyeccion de codigo
            puente = conexion.prepareStatement(sql);//15. crear puente a la base de datos y envie sentencia SQL
            puente.setString(1, id_tipo_producto); //16. asigne el primer ? lo que este en la variable usulogin 
            puente.setString(2, id_categoria);
            puente.setString(3, nombre_producto);
            puente.setString(4, id_planta);
            puente.setString(5, peso);
            puente.setString(6, url_imagen);
            puente.setString(7, productocol);
            puente.setString(8, id_muestreo);
            puente.setString(9, unidades_existentes);
            puente.setString(10, precio);
            puente.executeUpdate(); //17.actualizar db
            operacion = true; //si cumple todo cambia a true

        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            //18. independiente que pase en try catch haga finally
        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;//retorna ya que es un método booleano 
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update producto set id_tipo_producto=?, id_categoria=?, "
                    + "nombre_producto=?, id_planta=?,"
                    + " peso=?,url_imagen=?, productocol=?, id_muestreo=?,"
                    + "unidades_existentes=?, precio=? where id_producto=?";
            //? viene un parametro pero no se conoce cual es, para que no sea vulnerable a inyeccion de codigo
            // veh placa no se actualiza porque es la llave primaria

            puente = conexion.prepareStatement(sql);//crearpuente a la base de datos 
            //16. asigne el primer ? lo que este en la variable usulogin 
            puente.setString(1, id_tipo_producto);
            puente.setString(2, id_categoria);
            puente.setString(3, nombre_producto);
            puente.setString(4, id_planta);
            puente.setString(5, peso);
            puente.setString(6, url_imagen);
            puente.setString(7, productocol);
            puente.setString(8, id_muestreo);
            puente.setString(9, unidades_existentes);
            puente.setString(10, precio);
            puente.setString(11, id_producto);
            puente.executeUpdate(); //actualizar db
            operacion = true; //si cumple todo cambia a true
            //para que permita ingresar se debe registar primero datos en la clase de la foranea

        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            //18. independiente que pase en try catch haga finally
        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;//retorna ya que es un método booleano

    }

    //19 metodo propio
    public productoVO consultar_nombreProducto(String nombre_producto) {
        //metodo de tipo objeto retorna datos que estan en el vo
        //metodo que retorne objeto, si encuentra un producto que esta en la consulta 
        //agrega al VO los datos que van a retornar
        //sino encuentra retorna un VO vacio

        productoVO proVo = null; //20. declar objeto de tipo vo, null porque no tiene datos aun

        try {

            conexion = this.obtenerConexion();
            //21 establecer conexión , arriba es diferente porque se conecta desde a super clase
            sql = "select * from producto where id_producto=? "; //query
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_producto);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {  //22. next en el recorrido de la tabla, mientras que lo encuentre       
                //23crear objeto y trae el constructor y getstring obtener lo que encontro en la columna especificada
                proVo = new productoVO(id_producto, mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11));

            }

            //24 agregar sql excepcion e import porque son operaciones de base de datos
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion(); // independiente que pase en try catch haga finally
            } catch (Exception e) {

                //25 excepciones, agregar libreria logging
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
                //obtener log del error de la clase UsuarioDAO y categorizar

            }
        }
        return proVo;//retorna ya que es un método booleano
    }
    //otro metodo publico

    public ArrayList<productoVO> listar() {  // ALMACENAR objetos VO, lo almacena en posiciones
        //se puede listar directamente en jsp y no en controlador ya que no pide datos

        productoVO proVo = null; //declarar VO
        ArrayList<productoVO> listaProductos = new ArrayList<>(); //crear arraylist        

        try {
            conexion = this.obtenerConexion();

            sql = "select * from producto"; //query
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                proVo = new productoVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11));

                listaProductos.add(proVo); //lo agrega a la posicion del arreglo hasta que ya no encuentre

            }

        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion(); // independiente que pase en try catch haga finally
            } catch (Exception e) {

                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return listaProductos;
    }

}

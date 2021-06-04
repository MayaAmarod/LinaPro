package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.util.Crud;
import com.lina.vo.PersonasVO;
import com.lina.vo.UsuariosVO;
import com.lina.vo.productoVO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase donde se van a realizar todas las transacciones de base de datos de la
 * tabla usuario DAO(data access objetc)
 *
 * @author spier
 */
public class UsuarioDAO extends Conexion {

    UsuariosVO usuarioVO = new UsuariosVO();
    PersonasVO personaVO = new PersonasVO();
    private ResultSet mensajero;
    public String sql;
    private PreparedStatement puente;
    public boolean operacion = false;
    
    private String Pid_usuario ="", Pusuario="", Pdocumento="", Pcorreo="", Pdireccion="", Pcontraseña="",
            PtelefonoFijo="", Pcelular="", PtipoUsuario="", Ptipodocumento="", Pid_estado="";
    public UsuarioDAO() {
    }
    
    public UsuarioDAO(PersonasVO perVO) {        
        super(); // se usa super se traen variables de una superClase, ya que no se puede hacer doble herencia       
        try {
            conexion = this.obtenerConexion(); //10.extends Conexion heredar conexion 
            //11. traer valores que estan en el VO
            Pid_usuario = perVO.getPid_usuario(); //en la varible declarada aqui , obtener valor que esta en vehVO
            Pusuario = perVO.getPusuario();
            Pdocumento = perVO.getPdocumento();
            Pcorreo = perVO.getPcorreo();
            Pdireccion = perVO.getPdireccion();
            Pcontraseña = perVO.getPcontraseña();
            PtelefonoFijo = perVO.getPtelefonoFijo();
            Pcelular = perVO.getPcelular();
            PtipoUsuario = perVO.getPtipoUsuario();
            Ptipodocumento = perVO.getPtipodocumento();
            Pid_estado = perVO.getPid_estado();
        } catch (Exception e) {
            //12 excepciones, agregar libreria logging
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            //obtener log del error de la clase y categorizar
        }
    }    
    
    /**
     * valida si el usuario y la clave existen en base de datos
     *
     * @param correo
     * @param clave
     * @return
     */
   	public UsuariosVO autenticacion(String correo, String clave) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select * from usuario where correo= ? and clave= ?";
            pst = obtenerConexion().prepareStatement(consulta);
            /*pst.setString(1, usuarios.getUcorreo());
            pst.setString(2, usuarios.getUclave());*/
            pst.setString(1, correo);
            pst.setString(2, clave);

            rs = pst.executeQuery();
            if (rs.next()) {
                UsuariosVO user=new UsuariosVO();
                user.setNombre(rs.getString("nombre"));
                user.setUcorreo(rs.getString("correo"));
                user.setDirreccion(rs.getString("direccion"));
                user.setTelefonoFijo(rs.getString("telefono_fijo"));
                user.setTelefonoMovil(rs.getString("telefono_movil"));
                user.setIdTipoDocumento(rs.getInt("id_tipo_documento"));
                 user.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                 return user;
            }
        } catch (Exception ex) {
            System.err.println("ERROR " + ex);
        }
        return null;
    }
	
    
     public boolean verificarCorreo(String correo, String numeroDocumento) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select * from usuario where correo= ? and documento= ?";
            pst = obtenerConexion().prepareStatement(consulta);
            pst.setString(1, correo);
            pst.setString(2, numeroDocumento);

            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR " + ex);
        }
        return false;
    }

    /**
     * valida si el correo recibido ya existe en la base de datos
     *
     * @param correo
     * @return
     */
    public boolean exisisteUsuario(String correo) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select * from usuario where correo=?";
            pst = obtenerConexion().prepareStatement(consulta);
            pst.setString(1, correo.trim());
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR " + ex);
        }
        return false;
    }
    
    public ArrayList<PersonasVO> listar() {  // ALMACENAR objetos VO, lo almacena en posiciones
        //se puede listar directamente en jsp y no en controlador ya que no pide datos
        
        PersonasVO perVo = null; //declarar VO
        ArrayList<PersonasVO> listaUsuarios = new ArrayList<>(); //crear arraylist      
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario"; //query
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                perVo = new PersonasVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11));
                listaUsuarios.add(perVo); //lo agrega a la posicion del arreglo hasta que ya no encuentre
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion(); // independiente que pase en try catch haga finally
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaUsuarios;
    }

     public List<UsuariosVO> listarUsuarios() {
        List<UsuariosVO> usuarios=new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select * from usuario";
            pst = obtenerConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
           while (rs.next()) {
                UsuariosVO usuario=new UsuariosVO();
                usuario.setIdUsusario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuarios.add(usuario);
            }
        } catch (Exception ex) {
            System.err.println("ERROR " + ex);
        }
        return usuarios;
    }
    /**
     * registra un nuevo usuario en la base de datos
     *
     * @param nombre
     * @param clave
     * @param correo
     * @param numeroDocumento
     * @param tipoUsuario
     * @param tipoDocumento
     * @param direccion
     * @param celular
     * @param telefono
     * @param estado
     * @return
     */
    public boolean registrarUsuario(String nombre, String clave, String correo, String numeroDocumento,
            int tipoUsuario, int tipoDocumento, String direccion, String celular, String telefono, int estado) {
        PreparedStatement pst = null;
        try {
            String consulta = "insert into usuario (nombre,documento,correo,direccion,clave,telefono_fijo,telefono_movil,"
                    + "id_tipo_usuario,id_tipo_documento, id_estado) values(?,?,?,?,?,?,?,?,?,?);";
            pst = obtenerConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, numeroDocumento);
            pst.setString(3, correo.trim());
            pst.setString(4, direccion);
            pst.setString(5, clave);
            pst.setString(6, telefono);
            pst.setString(7, celular);
            pst.setInt(8, tipoUsuario);
            pst.setInt(9, tipoDocumento);
            pst.setInt(10, estado);
            pst.execute();
            return true;

        } catch (Exception ex) {
            System.err.println("ERROR " + ex);
            ex.printStackTrace();
        }
        return false;
    }

    public String cifrarClave(String clave) {
        try {

            //String clave = usuarioVO.getUclave();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(clave.getBytes("UTF-8"));
            StringBuilder claveCifrada = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    claveCifrada.append('0');
                }
                claveCifrada.append(hex);
            }
            return claveCifrada.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
    
     public UsuariosVO getUsuarioPorId(int idUsuario) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "select * from usuario where id_usuario= ?";
            pst = obtenerConexion().prepareStatement(consulta);
            pst.setInt(1, idUsuario);

            rs = pst.executeQuery();
            if (rs.next()) {
                UsuariosVO user=new UsuariosVO();
                user.setNombre(rs.getString("nombre"));
                user.setUcorreo(rs.getString("correo"));
                user.setDirreccion(rs.getString("direccion"));
                user.setTelefonoFijo(rs.getString("telefono_fijo"));
                user.setTelefonoMovil(rs.getString("telefono_movil"));
                user.setIdTipoDocumento(rs.getInt("id_tipo_documento"));
                 user.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                 return user;
            }
        } catch (Exception ex) {
            System.err.println("ERROR " + ex);
            ex.printStackTrace();
        }
        return null;
    }     
     
    public boolean actualizarRegistro() {
        try {
            sql = "update usuario set nombre=?, documento=?, "
                    + "correo=?, direccion=?,"
                    + " clave=?, telefono_fijo=?, telefono_movil=?, id_tipo_usuario=?, id_tipo_documento=?,"
                    + "id_estado=? where id_usuario=?";
            //? viene un parametro pero no se conoce cual es, para que no sea vulnerable a inyeccion de codigo
            // veh placa no se actualiza porque es la llave primaria

            puente = conexion.prepareStatement(sql);//crearpuente a la base de datos 
            //16. asigne el primer ? lo que este en la variable usulogin             
            puente.setString(1, Pusuario);
            puente.setString(2, Pdocumento);
            puente.setString(3, Pcorreo);
            puente.setString(4, Pdireccion);
            puente.setString(5, Pcontraseña);
            puente.setString(6, PtelefonoFijo);
            puente.setString(7, Pcelular);
            puente.setString(8, PtipoUsuario);
            puente.setString(9, Ptipodocumento);
            puente.setString(10, Pid_estado);
            puente.setString(11, Pid_usuario);
            puente.executeUpdate(); //actualizar db
            operacion = true; //si cumple todo cambia a true
            //para que permita ingresar se debe registar primero datos en la clase de la foranea

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            //18. independiente que pase en try catch haga finally
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;//retorna ya que es un método booleano
    }
    
    public Boolean Eliminar() {
        try {
            sql = "delete from usuario where id_usuario =?";
            //? viene un parametro pero no se conoce cual es, para que no sea vulnerable a inyeccion de codigo
            // veh placa no se actualiza porque es la llave primaria
            puente = conexion.prepareStatement(sql);//crearpuente a la base de datos 
            //16. asigne el primer ? lo que este en la variable usulogin 
            puente.setString(1, Pid_usuario);
            puente.executeUpdate(); //actualizar db
            operacion = true; //si cumple todo cambia a true
            //para que permita ingresar se debe registar primero datos en la clase de la foranea
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            //18. independiente que pase en try catch haga finally
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;//retorna ya que es un método booleano
    }
    
    //19 metodo propio
    public PersonasVO consultar_nombreUsuario(String nombre_usuario) {
        //metodo de tipo objeto retorna datos que estan en el vo
        //metodo que retorne objeto, si encuentra un producto que esta en la consulta 
        //agrega al VO los datos que van a retornar
        //sino encuentra retorna un VO vacio
        PersonasVO perVo = null; //20. declar objeto de tipo vo, null porque no tiene datos aun
        try {
            conexion = this.obtenerConexion();
            //21 establecer conexión , arriba es diferente porque se conecta desde a super clase
            sql = "select * from usuario where id_usuario=? "; //query
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Pid_usuario);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {  //22. next en el recorrido de la tabla, mientras que lo encuentre       
                //23crear objeto y trae el constructor y getstring obtener lo que encontro en la columna especificada
                perVo = new PersonasVO(Pid_usuario, mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11));
            }
            //24 agregar sql excepcion e import porque son operaciones de base de datos
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion(); // independiente que pase en try catch haga finally
            } catch (Exception e) {
                //25 excepciones, agregar libreria logging
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
                //obtener log del error de la clase UsuarioDAO y categorizar
            }
        }
        return perVo;//retorna ya que es un método booleano
    }
}
package com.lina.modelo;

import com.lina.util.Conexion;
import com.lina.vo.PersonasVO;
import com.lina.vo.UsuariosVO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase donde se van a realizar todas las transacciones de base de datos de la
 * tabla usuario DAO(data access objetc)
 *
 * @author spier
 */
public class UsuarioDAO extends Conexion {

    UsuariosVO usuarioVO = new UsuariosVO();
    PersonasVO personaVO = new PersonasVO();

    /**
     * valida si el usuario y la clave existen en base de datos
     *
     * @param correo
     * @param clave
     * @param Ucorreo
     * @param Uclave
     * @param usuarios
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
     * @return
     */
    public boolean registrarUsuario(String nombre, String clave, String correo, String numeroDocumento, int tipoUsuario, int tipoDocumento, String direccion, String celular) {
        PreparedStatement pst = null;
        try {

            String consulta = "insert into usuario (nombre, documento, correo, direccion, clave,telefono_movil,id_tipo_usuario,id_tipo_documento) values(?,?,?,?,?,?,?,?);";
            pst = obtenerConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, numeroDocumento);
            pst.setString(3, correo.trim());
            pst.setString(4, direccion);
            pst.setString(5, clave);
            pst.setString(6, celular);
            pst.setInt(7, tipoUsuario);
            pst.setInt(8, tipoDocumento);

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
}
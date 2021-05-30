package com.lina.vo;

public class UsuariosVO {

    private String Ucorreo, Uclave,nombre,documento,dirreccion,telefonoMovil,telefonoFijo;
    private int idTipoUsuario,idTipoDocumento, idUsusario, idEstado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public UsuariosVO(int idEstado) {
        this.idEstado = idEstado;
    }
    
    //Enviar
    public UsuariosVO() {
    }
    
    //Recibir
    public UsuariosVO(String Ucorreo, String Uclave) {
        this.Ucorreo = Ucorreo;
        this.Uclave = Uclave;
    }
    
    public String getUcorreo() {
        return Ucorreo;
    }

    public void setUcorreo(String Ucorreo) {
        this.Ucorreo = Ucorreo;
    }

    public String getUclave() {
        return Uclave;
    }

    public void setUclave(String Uclave) {
        this.Uclave = Uclave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getIdUsusario() {
        return idUsusario;
    }

    public void setIdUsusario(int idUsusario) {
        this.idUsusario = idUsusario;
    }

    

}


package com.lina.vo;


public class PersonasVO {

    private String Pid_usuario, Pusuario, Pdocumento, Pcorreo, Pdireccion, Pcontraseña,
            PtelefonoFijo, Pcelular, PtipoUsuario, Ptipodocumento, Pid_estado;
    
    public PersonasVO() {
    }    
    
    public PersonasVO(String Pid_usuario, String Pusuario, String Pdocumento, String Pcorreo, String Pdireccion, String Pcontraseña, String PtelefonoFijo, String Pcelular, String PtipoUsuario, String Ptipodocumento, String Pid_estado) {
        this.Pid_usuario = Pid_usuario;
        this.Pusuario = Pusuario;
        this.Pdocumento = Pdocumento;
        this.Pcorreo = Pcorreo;
        this.Pdireccion = Pdireccion;
        this.Pcontraseña = Pcontraseña;
        this.PtelefonoFijo = PtelefonoFijo;
        this.Pcelular = Pcelular;
        this.PtipoUsuario = PtipoUsuario;
        this.Ptipodocumento = Ptipodocumento;
        this.Pid_estado = Pid_estado;
    }
    
    public String getPid_usuario() {
        return Pid_usuario;
    }

    public void setPid_usuario(String Pid_usuario) {
        this.Pid_usuario = Pid_usuario;
    }

    public String getPusuario() {
        return Pusuario;
    }

    public void setPusuario(String Pusuario) {
        this.Pusuario = Pusuario;
    }

    public String getPdocumento() {
        return Pdocumento;
    }

    public void setPdocumento(String Pdocumento) {
        this.Pdocumento = Pdocumento;
    }

    public String getPcorreo() {
        return Pcorreo;
    }

    public void setPcorreo(String Pcorreo) {
        this.Pcorreo = Pcorreo;
    }

    public String getPdireccion() {
        return Pdireccion;
    }

    public void setPdireccion(String Pdireccion) {
        this.Pdireccion = Pdireccion;
    }

    public String getPcontraseña() {
        return Pcontraseña;
    }

    public void setPcontraseña(String Pcontraseña) {
        this.Pcontraseña = Pcontraseña;
    }

    public String getPtelefonoFijo() {
        return PtelefonoFijo;
    }

    public void setPtelefonoFijo(String PtelefonoFijo) {
        this.PtelefonoFijo = PtelefonoFijo;
    }

    public String getPcelular() {
        return Pcelular;
    }

    public void setPcelular(String Pcelular) {
        this.Pcelular = Pcelular;
    }

    public String getPtipoUsuario() {
        return PtipoUsuario;
    }

    public void setPtipoUsuario(String PtipoUsuario) {
        this.PtipoUsuario = PtipoUsuario;
    }

    public String getPtipodocumento() {
        return Ptipodocumento;
    }

    public void setPtipodocumento(String Ptipodocumento) {
        this.Ptipodocumento = Ptipodocumento;
    }

    public String getPid_estado() {
        return Pid_estado;
    }

    public void setPid_estado(String Pid_estado) {
        this.Pid_estado = Pid_estado;
    }
    
}

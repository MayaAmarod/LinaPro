
package com.lina.vo;


public class PersonasVO {
    private String Pusuario, Pcorreo, Ptipodocumento, Pdocumento, Pdireccion, Pcelular, Pcontraseña, PtelefonoFijo, PtipoUsuario;



    public PersonasVO(String Pusuario, String Pcorreo, String Ptipodocumento, String Pdocumento, String Pdireccion, String Pcelular, String Pcontraseña, String PtelefonoFijo, String PtipoUsuario) {
        this.Pusuario = Pusuario;
        this.Pcorreo = Pcorreo;
        this.Ptipodocumento = Ptipodocumento;
        this.Pdocumento = Pdocumento;
        this.Pdireccion = Pdireccion;
        this.Pcelular = Pcelular;
        this.Pcontraseña = Pcontraseña;
        this.PtelefonoFijo = PtelefonoFijo;
        this.PtipoUsuario = PtipoUsuario;
    }

    public PersonasVO() {
    }
    
        public String getPusuario() {
        return Pusuario;
    }

    public void setPusuario(String Pusuario) {
        this.Pusuario = Pusuario;
    }

    public String getPcorreo() {
        return Pcorreo;
    }

    public void setPcorreo(String Pcorreo) {
        this.Pcorreo = Pcorreo;
    }

    public String getPtipodocumento() {
        return Ptipodocumento;
    }

    public void setPtipodocumento(String Ptipodocumento) {
        this.Ptipodocumento = Ptipodocumento;
    }

    public String getPdocumento() {
        return Pdocumento;
    }

    public void setPdocumento(String Pdocumento) {
        this.Pdocumento = Pdocumento;
    }

    public String getPdireccion() {
        return Pdireccion;
    }

    public void setPdireccion(String Pdireccion) {
        this.Pdireccion = Pdireccion;
    }

    public String getPcelular() {
        return Pcelular;
    }

    public void setPcelular(String Pcelular) {
        this.Pcelular = Pcelular;
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

    public String getPtipoUsuario() {
        return PtipoUsuario;
    }

    public void setPtipoUsuario(String PtipoUsuario) {
        this.PtipoUsuario = PtipoUsuario;
    }
    
}

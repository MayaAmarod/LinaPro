package com.lina.vo;

public class UsuariosVO {

    private String Ucorreo, Uclave;
    
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

    

}

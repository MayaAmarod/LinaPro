package com.lina.controlador;


import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author spier
 */
public class PropiedadesCorreo {

    public static void envioCorreo(String host, String puerto, final String usuario,
            final String clave, String direccion, String asunto, String mensaje) throws AddressException, MessagingException {

        //Propiedades Servidor SMTP
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", host);
        propiedades.put("mail.smtp.port", puerto);
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true"); //-> starttls con una "t"

        Authenticator autenticar = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        };
        Session Sesion = Session.getInstance(propiedades, autenticar);
        Message msg = new MimeMessage(Sesion);      
        
        msg.setFrom(new InternetAddress(usuario));
        
        InternetAddress[] direcciones = {new InternetAddress(direccion)};
        msg.setRecipients(Message.RecipientType.TO, direcciones);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setText(mensaje);

        Transport.send(msg);

    }

    
    
    
    
    
    
    
}



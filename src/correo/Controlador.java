/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correo;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Bot Dexxtronex
 */
public class Controlador {
   public boolean enviarCorreo(Correo_E c){
        try{
            Properties p = new Properties();
            p.put("mail.smtp.host","smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable","true");
            p.setProperty("mail.smtp.port","587");
            p.setProperty("mail.smtp.user",c.getUsuarioCorreo());
            p.setProperty("mail.smtp.auth","true");
Session  s = Session.getDefaultInstance(p,null);
BodyPart texto = new MimeBodyPart();
texto.setText(c.getMensaje());
BodyPart adjunto = new MimeBodyPart();
if(!c.getruta().equals("")){
    adjunto.setDataHandler((new DataHandler(new FileDataSource(c.getruta()))));
    adjunto.setFileName(c.getrutanombre());
}
                 
                    MimeMultipart multiParte = new MimeMultipart();
                    multiParte.addBodyPart(texto);
 if(!c.getruta().equals("")){
   multiParte.addBodyPart(adjunto);
     
     
}                

MimeMessage mensaje = new MimeMessage(s);
mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
mensaje.setSubject(c.getUsuario(),c.getAsunto());

mensaje.setContent(multiParte);    
Transport t  = s.getTransport("smtp");
t.connect(c.getUsuarioCorreo(),c.getContraseña());
t.sendMessage(mensaje, mensaje.getAllRecipients());
t.close();
return true;

        }catch(Exception e){
            System.out.println("error"+e);
        }
        return false;    
    }
}

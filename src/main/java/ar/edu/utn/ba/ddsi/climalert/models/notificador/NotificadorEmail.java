package ar.edu.utn.ba.ddsi.climalert.models.notificador;

import ar.edu.utn.ba.ddsi.climalert.models.notificacion.Notificacion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificadorEmail implements Notificador{

    private final JavaMailSender mailSender;

    public NotificadorEmail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notificar(Notificacion notificacion){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(notificacion.getDestinatarios().toArray(new String[0]));
        mensaje.setSubject(notificacion.getAsunto());
        mensaje.setText(notificacion.getCuerpo());

        try{
            mailSender.send(mensaje);
            log.info("Email enviado a {}", notificacion.getDestinatarios());

        }catch (Exception e){
            log.error("Error al enviar email: {}", e.getMessage());
        }

    }
}

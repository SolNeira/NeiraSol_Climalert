package ar.edu.utn.ba.ddsi.climalert.utils.helpers;

import ar.edu.utn.ba.ddsi.climalert.models.notificacion.Notificacion;
import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificacionesFactory {

    private static final List<String> destinatarios = List.of(
            "admin@clima.com",
            "emergencias@clima.com",
            "meteorologia@clima.com"
    );

    public Notificacion crearAlertaClimatica(RegistroClimatico registroClimatico) {
            String asunto = "Alerta climática - " + registroClimatico.getUbicacion();
            String cuerpo = "Se detectó una alerta climática:\n" +
                            "Ubicacion: " + registroClimatico.getUbicacion() + "\n" +
                            "Temperatura: " + registroClimatico.getTemperatura() + "°C\n" +
                            "Humedad: " + registroClimatico.getHumedad() + "%\n" +
                            "Fecha y hora: " + registroClimatico.getFechaYHora();

            return new Notificacion(destinatarios, asunto, cuerpo);
        }
    }


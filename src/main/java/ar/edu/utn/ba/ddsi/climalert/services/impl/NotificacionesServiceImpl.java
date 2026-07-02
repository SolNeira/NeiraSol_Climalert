package ar.edu.utn.ba.ddsi.climalert.services.impl;

import ar.edu.utn.ba.ddsi.climalert.models.notificacion.Notificacion;
import ar.edu.utn.ba.ddsi.climalert.models.notificador.Notificador;
import ar.edu.utn.ba.ddsi.climalert.services.NotificacionesService;

import org.springframework.stereotype.Service;

@Service
public class NotificacionesServiceImpl implements NotificacionesService {

    private final Notificador notificador;

    public NotificacionesServiceImpl(Notificador notificador) {
        this.notificador = notificador;
    }

    public void enviarNotificacion(Notificacion notificacion){
        notificador.notificar(notificacion);
    }

}

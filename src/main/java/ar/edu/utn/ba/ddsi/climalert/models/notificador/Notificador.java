package ar.edu.utn.ba.ddsi.climalert.models.notificador;

import ar.edu.utn.ba.ddsi.climalert.models.notificacion.Notificacion;

public interface Notificador {
    void notificar (Notificacion notificacion);
}

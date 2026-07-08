package ar.edu.utn.ba.ddsi.climalert.models.notificacion;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Notificacion {
    private List<String> destinatarios;
    private String asunto;
    private String cuerpo;
}

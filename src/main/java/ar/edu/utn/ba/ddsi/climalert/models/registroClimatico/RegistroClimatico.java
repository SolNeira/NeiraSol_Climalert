package ar.edu.utn.ba.ddsi.climalert.models.registroClimatico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroClimatico {

    private Long id;
    private String ubicacion;
    private Double temperatura;
    private int humedad;
    private LocalDateTime fechaYHora;
    private boolean alertaEnviada = false;
}

package ar.edu.utn.ba.ddsi.climalert.utils.mappers;

import ar.edu.utn.ba.ddsi.climalert.dto.ClimaUbicacion;
import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//CAMBIAR NOMBRE A MAPPERCLIMAUBICACION
@Component
public class MapperRegistroClimatico {

    public RegistroClimatico mapToRegistroClimatico(ClimaUbicacion climaUbicacion){

        RegistroClimatico registroClimatico = new RegistroClimatico();

        registroClimatico.setTemperatura(climaUbicacion.getClima().getTemperatura());
        registroClimatico.setHumedad(climaUbicacion.getClima().getHumedad());
        registroClimatico.setUbicacion(climaUbicacion.getUbicacion().getNombre());
        registroClimatico.setFechaYHora(LocalDateTime.now());

        return registroClimatico;
    }
}

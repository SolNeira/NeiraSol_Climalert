package ar.edu.utn.ba.ddsi.climalert.models.condicionAlerta;

import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;
import org.springframework.stereotype.Component;

@Component
public class CondicionHumedadAlta implements CondicionDeAlerta{

    public boolean evaluarCondicion(RegistroClimatico registroClimatico){

        return  registroClimatico.getHumedad() > 60;

    }

}

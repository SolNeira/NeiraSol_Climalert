package ar.edu.utn.ba.ddsi.climalert.models.condicionAlerta;

import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;

public interface CondicionDeAlerta {

    public boolean evaluarCondicion(RegistroClimatico registroClimatico);

}

package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;

public interface MonitoreoClimaticoService {

    public boolean hayCondicionDeAlerta(RegistroClimatico registroClimatico);

    public void monitorearClima();
}

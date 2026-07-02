package ar.edu.utn.ba.ddsi.climalert.services.impl;

import ar.edu.utn.ba.ddsi.climalert.models.condicionAlerta.CondicionDeAlerta;
import ar.edu.utn.ba.ddsi.climalert.models.notificacion.Notificacion;
import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;
import ar.edu.utn.ba.ddsi.climalert.models.repositories.RegistroClimaticoRepository;
import ar.edu.utn.ba.ddsi.climalert.services.MonitoreoClimaticoService;
import ar.edu.utn.ba.ddsi.climalert.services.RegistroClimaticoService;
import ar.edu.utn.ba.ddsi.climalert.services.NotificacionesService;
import ar.edu.utn.ba.ddsi.climalert.utils.helpers.NotificacionesFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MonitoreoClimaticoServiceImpl implements MonitoreoClimaticoService {

    private final RegistroClimaticoRepository registroClimaticoRepository;
    private final NotificacionesService notificacionService;
    private final NotificacionesFactory notificacionesFactory;

    private final List<CondicionDeAlerta> condicionesDeAlerta;

    public MonitoreoClimaticoServiceImpl(RegistroClimaticoRepository registroClimaticoRepository, NotificacionesService notificacionService, NotificacionesFactory notificacionesFactory, List<CondicionDeAlerta> condicionesDeAlerta) {
        this.registroClimaticoRepository = registroClimaticoRepository;
        this.notificacionService = notificacionService;
        this.notificacionesFactory = notificacionesFactory;
        this.condicionesDeAlerta = condicionesDeAlerta;
    }

    public boolean hayCondicionDeAlerta(RegistroClimatico registroClimatico){
        return condicionesDeAlerta.stream().anyMatch(condicion -> condicion.evaluarCondicion(registroClimatico));
    }

    public void monitorearClima(){

        Optional<RegistroClimatico> ultimo = registroClimaticoRepository.findUltimo();

        if(ultimo.isEmpty()){
            return;
        }

        RegistroClimatico ultimoRegistroClimatico = ultimo.get();

        if(ultimoRegistroClimatico.isAlertaEnviada()) {
            return;
        }

        if(this.hayCondicionDeAlerta(ultimoRegistroClimatico)){
            this.enviarAlerta(ultimoRegistroClimatico);
        }
    }

     public void enviarAlerta(RegistroClimatico registroClimatico){
         Notificacion notificacion = notificacionesFactory.crearAlertaClimatica(registroClimatico);
         notificacionService.enviarNotificacion(notif  icacion);
         registroClimatico.setAlertaEnviada(true);
         registroClimaticoRepository.save(registroClimatico);
     }
}

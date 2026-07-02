package ar.edu.utn.ba.ddsi.climalert.schedulers;

import ar.edu.utn.ba.ddsi.climalert.services.MonitoreoClimaticoService;
import ar.edu.utn.ba.ddsi.climalert.services.RegistroClimaticoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MonitoreoClimaticoScheduler {

    private final RegistroClimaticoService registroClimaticoService;
    private final MonitoreoClimaticoService monitoreoClimaticoService;

    public MonitoreoClimaticoScheduler(RegistroClimaticoService registroClimaticoService, MonitoreoClimaticoService monitoreoClimaticoService) {
        this.registroClimaticoService = registroClimaticoService;
        this.monitoreoClimaticoService = monitoreoClimaticoService;
    }

    @Scheduled(fixedRate = 300000) //cada 5 minutos
    public void obtenerClima(){
        registroClimaticoService.registrarClima();
    }

    @Scheduled(fixedRate = 60000) //cada 1 minuto
    public void analizarClima(){
        monitoreoClimaticoService.monitorearClima();
    }

}

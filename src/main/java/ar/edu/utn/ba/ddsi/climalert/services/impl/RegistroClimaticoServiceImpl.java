package ar.edu.utn.ba.ddsi.climalert.services.impl;

import ar.edu.utn.ba.ddsi.climalert.clients.WeatherApiClient;
import ar.edu.utn.ba.ddsi.climalert.dto.ClimaUbicacion;
import ar.edu.utn.ba.ddsi.climalert.models.condicionAlerta.CondicionDeAlerta;
import ar.edu.utn.ba.ddsi.climalert.models.notificacion.Notificacion;
import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;
import ar.edu.utn.ba.ddsi.climalert.models.repositories.RegistroClimaticoRepository;
import ar.edu.utn.ba.ddsi.climalert.services.RegistroClimaticoService;
import ar.edu.utn.ba.ddsi.climalert.services.NotificacionesService;
import ar.edu.utn.ba.ddsi.climalert.utils.helpers.NotificacionesFactory;
import ar.edu.utn.ba.ddsi.climalert.utils.mappers.MapperRegistroClimatico;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RegistroClimaticoServiceImpl implements RegistroClimaticoService {

    private final WeatherApiClient weatherApiClient;
    private final RegistroClimaticoRepository registroClimaticoRepository;
    private final MapperRegistroClimatico mapperRegistroClimatico;

    private final List<CondicionDeAlerta> condicionesDeAlerta;

    public RegistroClimaticoServiceImpl(WeatherApiClient weatherApiClient, RegistroClimaticoRepository registroClimaticoRepository, MapperRegistroClimatico mapperRegistroClimatico, List<CondicionDeAlerta> condicionesDeAlerta) {
        this.weatherApiClient = weatherApiClient;
        this.registroClimaticoRepository = registroClimaticoRepository;
        this.mapperRegistroClimatico = mapperRegistroClimatico;
        this.condicionesDeAlerta = condicionesDeAlerta;
    }

    public void registrarClima(){
        try {
            ClimaUbicacion climaUbicacion = weatherApiClient.obtenerClimaActual();

            RegistroClimatico registroClimatico = mapperRegistroClimatico.mapToRegistroClimatico(climaUbicacion);

            registroClimaticoRepository.save(registroClimatico);

            log.info("Registro guardado: {} - {}°C - {}% humedad", registroClimatico.getUbicacion(), registroClimatico.getTemperatura(), registroClimatico.getHumedad());

        } catch (Exception e) {
            log.error("Error al obtener el clima: {}", e.getMessage());
        }
    }
}

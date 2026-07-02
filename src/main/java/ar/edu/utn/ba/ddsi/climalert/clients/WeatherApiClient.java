package ar.edu.utn.ba.ddsi.climalert.clients;

import ar.edu.utn.ba.ddsi.climalert.config.RestWeatherProperties;
import ar.edu.utn.ba.ddsi.climalert.dto.ClimaUbicacion;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiClient {

    private final RestTemplate restTemplate;
    private final RestWeatherProperties properties;

    public WeatherApiClient(RestTemplate restTemplate, RestWeatherProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public ClimaUbicacion obtenerClimaActual() {
        String url = properties.getBaseUrl()
                + "/current.json?key="
                + properties.getApiKey()
                + "&q="
                + properties.getUbicacion();

        return restTemplate.getForObject(url, ClimaUbicacion.class);
    }
}

package ar.edu.utn.ba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clima {

    @JsonProperty("last_updated")
    private String ultimaActualizacion;

    @JsonProperty("temp_c")
    private Double temperatura;

    @JsonProperty("humidity")
    private int humedad;
}

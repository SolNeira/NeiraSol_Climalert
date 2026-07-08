package ar.edu.utn.ba.ddsi.climalert.models.repositories.inMemoryMonitoreoClimaticoRepo;

import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;
import ar.edu.utn.ba.ddsi.climalert.models.repositories.RegistroClimaticoRepository;
import ar.edu.utn.ba.ddsi.climalert.utils.GeneradorIdSecuencial;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Como aun no tuvimos la oportunidad de ver persistencia de datos, hice un Repositorio en memoria
@Repository
public class InMemoryRegistroClimaticoRepository implements RegistroClimaticoRepository {

    private final List<RegistroClimatico> registrosClimaticos = new ArrayList<>();

    private final GeneradorIdSecuencial generadorId = new GeneradorIdSecuencial();

    public RegistroClimatico save(RegistroClimatico registroClimatico){

        if (registroClimatico.getId() == null) {
            registroClimatico.setId(generadorId.siguiente());
            registrosClimaticos.add(registroClimatico);
            return registroClimatico;
        }
        delete(registroClimatico);
        registrosClimaticos.add(registroClimatico);
        return registroClimatico;
    }

    public Optional<RegistroClimatico> findUltimo() {
        if(registrosClimaticos.isEmpty()){
            return Optional.empty();
        }

        int posicionUltimo = registrosClimaticos.size() - 1;

        return Optional.of(registrosClimaticos.get(posicionUltimo));
    }

    public List<RegistroClimatico> findAll() {
        return registrosClimaticos;
    }

    public Optional<RegistroClimatico> findById(Long id) {
        return registrosClimaticos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void delete(RegistroClimatico registroClimatico) {
        if (registroClimatico.getId() == null) {
            return;
        }
        registrosClimaticos.removeIf(p -> p.getId().equals(registroClimatico.getId()));
    }
}

package ar.edu.utn.ba.ddsi.climalert.models.repositories;

import ar.edu.utn.ba.ddsi.climalert.models.registroClimatico.RegistroClimatico;

import java.util.List;
import java.util.Optional;

public interface RegistroClimaticoRepository {

    public RegistroClimatico save(RegistroClimatico registroClimatico);

    public Optional<RegistroClimatico> findUltimo();

    public List<RegistroClimatico> findAll();

    public Optional<RegistroClimatico> findById(Long id);

    public void delete(RegistroClimatico registroClimatico);
}

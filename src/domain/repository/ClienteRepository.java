package domain.repository;

import domain.model.Cliente;
import java.util.List;
import java.util.Optional;

// Interfaz de repositorio para Cliente en el dominio
public interface ClienteRepository {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
    void deleteById(Integer id);
    // Aquí puedes aplicar el patrón Repository, Decorator, Adapter, etc.
}

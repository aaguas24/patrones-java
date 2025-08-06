package infrastructure;

import domain.model.Pedido;
import domain.repository.PedidoRepositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Implementación concreta del repositorio usando Spring Data JPA
@Repository
public interface PedidoRepositorioJpa extends PedidoRepositorio, JpaRepository<Pedido, Integer> {
    // Aquí puedes aplicar Adapter, Decorator, Proxy, etc. sobre la interfaz del dominio
}

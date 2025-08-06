package domain.service;

import domain.model.Pedido;
import domain.repository.PedidoRepositorio;
import java.util.List;

// Servicio de dominio que depende de la interfaz PedidoRepositorio del dominio.
// La implementación concreta (por ejemplo, JPA) se provee en infrastructure y se inyecta aquí.
// Así puedes cambiar la tecnología de persistencia sin modificar el servicio ni el dominio.
public class PedidoService {
    private PedidoRepositorio repositorio;

    // En una aplicación Spring, puedes usar @Autowired para inyectar la implementación:
    // @Autowired
    // public PedidoService(PedidoRepositorio repositorio) {
    //     this.repositorio = repositorio;
    // }

    // En este ejemplo, se usa el constructor para mayor claridad y testabilidad.
    public PedidoService(PedidoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void crearPedido(Pedido pedido) {
        repositorio.guardar(pedido);
        // Aquí puede aplicarse Observer para notificar a otros servicios
    }

    public List<Pedido> listarPedidos() {
        return repositorio.obtenerTodos();
    }

    // Aquí podrías aplicar:
    // - Strategy: para calcular descuentos
    // - Facade: para simplificar operaciones complejas
    // - Singleton: para que el servicio sea único
    // - Adapter: para adaptar servicios externos
    // - Decorator: para agregar funcionalidades dinámicamente
    // - Composite: para manejar servicios agrupados
}

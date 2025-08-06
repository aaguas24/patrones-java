package controladores;

import domain.model.Cliente;
import domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // Ejemplo de integración entre paquetes: controlador llama al servicio, que usa el repositorio
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        // Aquí puedes aplicar el patrón Builder, Factory, etc.
        return clienteService.crearCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        // Aquí puedes aplicar el patrón Strategy, Decorator, etc.
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obtenerClientePorId(@PathVariable int id) {
        // Aquí puedes aplicar el patrón Adapter, Proxy, etc.
        return clienteService.obtenerClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id) {
        // Aquí puedes aplicar el patrón Command, Observer, etc.
        clienteService.eliminarCliente(id);
    }
}

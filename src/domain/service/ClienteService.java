package domain.service;

import domain.model.Cliente;
import infrastructure.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Ejemplo CRUD básico
    public Cliente crearCliente(Cliente cliente) {
        // Aquí puedes aplicar el patrón Factory, Builder, etc.
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        // Aquí puedes aplicar el patrón Strategy, Decorator, etc.
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(int id) {
        // Aquí puedes aplicar el patrón Adapter, Proxy, etc.
        return clienteRepository.findById(id);
    }

    public void eliminarCliente(int id) {
        // Aquí puedes aplicar el patrón Command, Observer, etc.
        clienteRepository.deleteById(id);
    }
}



import domain.model.Cliente;
import domain.model.Producto;
import domain.model.Pedido;
import domain.repository.PedidoRepositorio;
import domain.repository.PedidoRepositorioMem;
import domain.service.PedidoService;
import application.PedidoFacade;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear entidades
        Cliente cliente = new Cliente(1, "Juan", "juan@email.com");
        Producto prod1 = new Producto(1, "Libro", 20.0);
        Producto prod2 = new Producto(2, "Lapiz", 2.5);
        Pedido pedido = new Pedido(1, cliente, Arrays.asList(prod1, prod2));

        // Crear repositorio y facade de aplicación
        PedidoRepositorio repo = new PedidoRepositorioMem();
        PedidoFacade facade = new PedidoFacade(repo);

        // Registrar pedido usando el facade
        facade.registrarPedido(pedido);

        // Consultar pedidos registrados y mostrar resultado
        System.out.println("Pedidos registrados:");
        for (Pedido p : facade.obtenerPedidos()) {
            System.out.println("Pedido " + p.getId() + " de " + p.getCliente().getNombre() + " por $" + p.getTotal());
        }
        // El controlador solo orquesta el flujo, sin lógica de negocio.
    }
}

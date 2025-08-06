# Ejemplo básico de interacción entre paquetes siguiendo DDD

A continuación se muestra un flujo simple que ejemplifica cómo interactúan los paquetes principales del proyecto usando las clases ya existentes:

---

## 1. Controlador (controladores/Main.java)
Recibe la petición y orquesta el flujo.
```java
Cliente cliente = new Cliente(1, "Juan", "juan@email.com");
Producto prod1 = new Producto(1, "Libro", 20.0);
Producto prod2 = new Producto(2, "Lapiz", 2.5);
Pedido pedido = new Pedido(1, cliente, Arrays.asList(prod1, prod2));

PedidoRepositorio repo = new PedidoRepositorio();
PedidoService service = new PedidoService(repo);
service.crearPedido(pedido);
```

## 2. Entidades (domain/model)
Representan los datos principales del negocio.
- `Cliente`, `Producto`, `Pedido`

## 3. Repositorio (domain/repository/PedidoRepositorio.java)
Gestiona la persistencia de pedidos.
- `guardar(Pedido pedido)` almacena el pedido en memoria.

## 4. Servicio de dominio (domain/service/PedidoService.java)
Contiene la lógica de negocio para gestionar pedidos.
- `crearPedido(Pedido pedido)` llama al repositorio para guardar el pedido.

## 5. Facade de aplicación (application/PedidoFacade.java)
Expone una interfaz simplificada para registrar y consultar pedidos.
```java
PedidoFacade facade = new PedidoFacade(repo);
facade.registrarPedido(pedido);
List<Pedido> pedidos = facade.obtenerPedidos();
```

## 6. Ejemplo de consulta y salida
```java
System.out.println("Pedidos registrados:");
for (Pedido p : pedidos) {
    System.out.println("Pedido " + p.getId() + " de " + p.getCliente().getNombre() + " por $" + p.getTotal());
}
```

---

**Resumen del flujo:**
- El controlador crea entidades y las pasa al servicio de dominio.
- El servicio de dominio usa el repositorio para persistir los datos.
- El facade de aplicación expone métodos para registrar y consultar pedidos.
- El controlador muestra el resultado al usuario.

**Buenas prácticas aplicadas:**
- Cada paquete tiene una responsabilidad clara.
- El dominio no depende de la infraestructura ni de la aplicación.
- El controlador no contiene lógica de negocio, solo orquesta el flujo.
- El facade simplifica la interacción con el sistema.

Puedes extender este ejemplo agregando DTOs, validaciones, patrones y lógica adicional según tus necesidades.

# Proyecto Java: Sistema de Gestión de Pedidos

Este proyecto está organizado para servir como base de estudio y práctica de patrones de diseño en Java. Incluye ejemplos y comentarios sobre dónde aplicar Factory, Singleton, Strategy, Observer, Builder y Facade.

## Estructura de paquetes
- `domain/model`: Entidades y objetos de valor (Pedido, Cliente, Producto)
- `domain/service`: Servicios de dominio (lógica de negocio)
- `domain/repository`: Interfaces de repositorio del dominio
- `domain/pattern`: Implementaciones y contratos de patrones de diseño
- `application`: Servicios de aplicación y fachada
- `application/dto`: Objetos de transferencia de datos (DTOs)
- `infrastructure`: Implementaciones técnicas (repositorios JPA, integración externa)
- `controladores`: Controladores REST y entrada principal
- `shared`: Utilidades, validadores, excepciones, componentes comunes

## Cómo compilar y ejecutar
1. Compila los archivos Java:
   ```shell
   javac src/**/*.java
   ```
2. Ejecuta la clase principal:
   ```shell
   java src.controladores.Main
   ```

## Patrones sugeridos
- **Factory**: Creación de pedidos/productos.
- **Singleton**: Servicio de gestión de pedidos.
- **Strategy**: Cálculo de descuentos.
- **Observer**: Notificación de cambios en pedidos.
- **Builder**: Construcción de objetos Pedido complejos.
- **Facade**: Interfaz simplificada para operaciones comunes.

## Notas
No incluye interfaz gráfica. Todo el código es para lógica y estructura.

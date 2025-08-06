# Guía de interacciones y buenas prácticas DDD en la arquitectura del proyecto

## Interacciones entre paquetes y clases

### 1. **domain/model/**
- Contiene entidades y objetos de valor.
- Se relacionan entre sí mediante asociaciones directas (por ejemplo, `Pedido` tiene una lista de `Producto`).
- No dependen de otras capas; son el núcleo del negocio.

### 2. **domain/service/**
- Servicios de dominio que encapsulan lógica de negocio que no pertenece a una sola entidad.
- Interactúan con entidades (`domain/model`) y repositorios (`domain/repository`).
- Ejemplo: `PedidoService` recibe un `Pedido` y lo guarda usando `PedidoRepositorio`.

### 3. **domain/repository/**
- Interfaces y clases para acceso a datos del dominio.
- Los servicios de dominio llaman a los repositorios para persistir o recuperar entidades.
- Ejemplo: `PedidoRepositorio.guardar(pedido)`.

### 4. **domain/pattern/**
- Implementaciones de patrones de diseño aplicados al dominio (Strategy, Observer, Builder, etc.).
- Se usan desde servicios, entidades o repositorios según el patrón.
- Ejemplo: `DescuentoStrategy` es usado por `PedidoService` para calcular descuentos.

### 5. **application/**
- Orquesta casos de uso y coordina la interacción entre el dominio y la infraestructura.
- Expone servicios de aplicación (por ejemplo, `PedidoFacade`) que usan servicios y repositorios del dominio.
- Recibe y retorna DTOs para comunicación con otras capas.

### 6. **infrastructure/**
- Implementa detalles técnicos: persistencia, integración externa, adaptadores, etc.
- Clases de infraestructura implementan interfaces de repositorio y pueden usar servicios de dominio para lógica adicional.
- Ejemplo: `PedidoRepositorioImpl` en infraestructura implementa la interfaz `PedidoRepositorio` y se conecta a una base de datos.
- Se recomienda que la infraestructura dependa del dominio, nunca al revés.

### 7. **shared/**
- Utilidades, excepciones, tipos comunes y componentes reutilizables.
- Aquí pueden ir anotaciones personalizadas, validadores, DTOs genéricos, etc.

### 8. **application/dto/**
- DTOs para transferir datos entre la capa de aplicación y otras capas.
- Se validan antes de ser usados en servicios de aplicación.

## Ejemplo de integración
- Un controlador (en presentación o infraestructura) recibe un DTO.
- El DTO se valida (puedes crear una anotación en `shared/validation` y un validador en `shared/validator`).
- El controlador llama a un servicio de aplicación (`application/PedidoFacade`) pasando el DTO.
- El servicio de aplicación transforma el DTO en una entidad (`domain/model/Pedido`) y usa un servicio de dominio (`domain/service/PedidoService`).
- El servicio de dominio usa un repositorio (`domain/repository/PedidoRepositorio`) para persistir la entidad.
- Si se requiere lógica técnica (persistencia, integración externa), el repositorio es implementado en `infrastructure/`.

## Buenas prácticas DDD
- Mantén el dominio independiente de la infraestructura y la aplicación.
- Usa interfaces en el dominio y sus implementaciones en infraestructura.
- Los servicios de aplicación orquestan casos de uso, no contienen lógica de negocio.
- Los DTOs deben validarse antes de ser usados; crea anotaciones y validadores reutilizables en `shared/`.
- Los patrones de diseño deben estar en `domain/pattern` si afectan el dominio, o en `shared/` si son genéricos.
- Evita dependencias cíclicas entre paquetes.
- Documenta las responsabilidades y relaciones de cada clase y paquete.

## Ejemplo de anotación para validación de DTO
- Crea una anotación en `shared/validation/ValidEmail.java`:
  ```java
  package shared.validation;
  import java.lang.annotation.*;
  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  public @interface ValidEmail {}
  ```
- Implementa un validador en `shared/validator/EmailValidator.java` que use la anotación.
- Aplica la anotación en el DTO y valida antes de procesar el caso de uso.

---

Esta guía te ayudará a mantener una arquitectura limpia, modular y alineada con DDD, facilitando la integración y el mantenimiento del proyecto.

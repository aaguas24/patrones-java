# Estructura de paquetes basada en DDD (Domain-Driven Design)

La arquitectura del proyecto se organiza en los siguientes paquetes principales:

- **domain/model/**: Entidades y objetos de valor del dominio (ej. Cliente, Producto, Pedido).
- **domain/service/**: Servicios de dominio que contienen lógica de negocio relevante para el dominio.
- **domain/repository/**: Interfaces y repositorios para acceso a datos del dominio.
- **domain/pattern/**: Implementaciones y contratos de patrones de diseño aplicados al dominio (ej. Strategy, Observer, Builder, etc).
- **application/**: Servicios de aplicación, casos de uso y lógica de orquestación entre el dominio y la infraestructura.
- **infrastructure/**: Implementaciones técnicas, adaptadores, persistencia, integración con sistemas externos.
- **shared/**: Utilidades, excepciones, tipos comunes y componentes reutilizables.

## Justificación
- **domain/model**: Aquí deben ir las entidades centrales del negocio, siguiendo DDD, para mantener la lógica y reglas del dominio aisladas.
- **domain/service**: Los servicios de dominio encapsulan operaciones que no pertenecen a una sola entidad, pero sí al dominio.
- **domain/repository**: Permite abstraer el acceso a datos, facilitando el cambio de tecnología sin afectar el dominio.
- **domain/pattern**: Facilita la reutilización y organización de patrones de diseño que afectan el dominio.
- **application**: Orquesta los casos de uso y coordina la interacción entre el dominio y la infraestructura.
- **infrastructure**: Separa las dependencias técnicas y detalles de implementación, manteniendo el dominio puro.
- **shared**: Centraliza utilidades y componentes comunes para evitar duplicidad y facilitar el mantenimiento.

Esta estructura promueve la separación de responsabilidades, la extensibilidad y el mantenimiento del proyecto, siguiendo los principios de DDD y buenas prácticas de arquitectura.

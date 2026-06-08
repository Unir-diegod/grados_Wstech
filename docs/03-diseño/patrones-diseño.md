# Patrones de Diseño

## Objetivo

Describir los patrones de diseño utilizados en la implementación de Wastech para garantizar una arquitectura mantenible, escalable y desacoplada.

---

# 1. Patrón MVC (Model - View - Controller)

## Descripción

El patrón MVC separa la lógica de negocio, la interfaz de usuario y el manejo de solicitudes.

## Implementación en Wastech

### Model

Representa las entidades del sistema.

Ejemplos:

* Usuario
* Dispositivo
* Sensor
* Lectura
* Alerta

### View

Corresponde a la interfaz PWA utilizada por los usuarios.

### Controller

Gestiona las solicitudes HTTP recibidas por la API.

Ejemplos:

```text
AuthController
UsuarioController
LecturaController
AlertaController
```

## Beneficios

* Separación de responsabilidades.
* Mayor mantenibilidad.
* Facilita las pruebas.

---

# 2. Patrón Service Layer

## Descripción

Centraliza la lógica de negocio en una capa independiente de los controladores.

## Implementación en Wastech

Los controladores delegan las operaciones a servicios especializados.

Ejemplos:

```text
UsuarioService
AuthService
LecturaService
AlertaService
```

## Beneficios

* Evita lógica de negocio en los controladores.
* Facilita reutilización de código.
* Mejora la organización del proyecto.

---

# 3. Patrón Repository

## Descripción

Abstrae el acceso a la base de datos mediante interfaces.

## Implementación en Wastech

Utilizando Spring Data JPA.

Ejemplos:

```text
UsuarioRepository
LecturaRepository
AlertaRepository
DispositivoRepository
```

## Beneficios

* Reduce código repetitivo.
* Facilita consultas a la base de datos.
* Mejora la mantenibilidad.

---

# 4. Inyección de Dependencias (Dependency Injection)

## Descripción

Permite que Spring gestione automáticamente la creación y entrega de dependencias.

## Implementación en Wastech

Los servicios y repositorios son inyectados mediante Spring Framework.

Ejemplo conceptual:

```text
Controller
    ↓
Service
    ↓
Repository
```

## Beneficios

* Bajo acoplamiento.
* Mayor facilidad para pruebas.
* Mejor escalabilidad.

---

# Arquitectura Aplicada

```text
PWA
 ↓
Controllers
 ↓
Services
 ↓
Repositories
 ↓
MySQL
```

---

# Conclusión

Wastech implementa una arquitectura basada en los patrones MVC, Service Layer, Repository e Inyección de Dependencias. Estos patrones permiten mantener una separación clara de responsabilidades, mejorar la escalabilidad del sistema y facilitar futuras tareas de mantenimiento y evolución.

# 5. DTO (Data Transfer Object)

## Descripción

El patrón DTO permite transportar información entre las capas de la aplicación sin exponer directamente las entidades de persistencia.

## Implementación en Wastech

Se utilizan DTO para las operaciones de autenticación, gestión de usuarios y transferencia de datos provenientes de los sensores IoT.

### Ejemplos

- LoginRequestDTO
- LoginResponseDTO
- UsuarioDTO
- LecturaDTO
- AlertaDTO

## Beneficios

- Evita exponer entidades directamente.
- Reduce el acoplamiento entre capas.
- Mejora la seguridad de la información.
- Facilita la validación de datos de entrada y salida.
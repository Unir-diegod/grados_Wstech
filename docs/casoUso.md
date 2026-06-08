# 📋 Casos de Uso - Sistema Wastech

> Plataforma inteligente para la gestión y monitoreo de procesos de deshidratación de residuos orgánicos mediante tecnologías IoT.

---

# 🎭 Actores del Sistema

| Actor               | Descripción                           |
| ------------------- | ------------------------------------- |
| 👨‍💼 Administrador | Gestiona completamente el sistema     |
| 👤 Cliente          | Consulta y monitorea sus procesos     |
| 🤖 Arduino          | Envía información de sensores         |
| 🌡️ Sensor          | Genera datos de temperatura y humedad |

---

# 🏗️ Visión General del Sistema

```mermaid
graph TD

A[Administrador]
B[Cliente]
C[Arduino]
D[Sensores]

A --> E[Gestión Usuarios]
A --> F[Gestión Clientes]
A --> G[Materias Primas]
A --> H[Compostajes]
A --> I[Procesos]

B --> I
B --> J[Historial]
B --> K[Monitoreo]

C --> K
D --> K
```

---

# 🔐 Caso de Uso: Iniciar Sesión

## Objetivo

Permitir el acceso seguro al sistema.

## Actores

* Administrador
* Cliente

## Flujo Principal

```mermaid
sequenceDiagram

actor Usuario

participant Login
participant Security
participant BaseDatos

Usuario->>Login: Usuario y contraseña

Login->>Security: Solicitar autenticación

Security->>BaseDatos: Buscar usuario

BaseDatos-->>Security: Usuario válido

Security-->>Login: Acceso autorizado

Login-->>Usuario: Dashboard
```

---

# 👥 Caso de Uso: Gestionar Usuarios

## Actor

Administrador

## Objetivo

Administrar las cuentas del sistema.

## Funcionalidades

* Crear usuario
* Editar usuario
* Eliminar usuario
* Consultar usuario

```mermaid
flowchart TD

A[Administrador]

A --> B[Crear Usuario]
A --> C[Editar Usuario]
A --> D[Eliminar Usuario]
A --> E[Consultar Usuario]
```

---

# 🧑‍💼 Caso de Uso: Gestionar Clientes

## Actor

Administrador

## Objetivo

Administrar los clientes registrados.

```mermaid
flowchart TD

A[Administrador]

A --> B[Registrar Cliente]
A --> C[Modificar Cliente]
A --> D[Consultar Cliente]
```

---

# 🌱 Caso de Uso: Gestionar Materia Prima

## Actor

Administrador

## Objetivo

Registrar materiales que serán procesados.

```mermaid
flowchart LR

A[Administrador]

A --> B[Crear Materia Prima]
A --> C[Editar Materia Prima]
A --> D[Eliminar Materia Prima]
A --> E[Consultar Materia Prima]
```

---

# ♻️ Caso de Uso: Gestionar Compostaje

## Actor

Administrador

## Objetivo

Configurar parámetros de compostaje.

```mermaid
flowchart LR

A[Administrador]

A --> B[Crear Compostaje]
A --> C[Modificar Compostaje]
A --> D[Consultar Compostaje]
```

---

# 🔥 Caso de Uso Principal: Crear Proceso de Deshidratación

## Actores

* Administrador
* Cliente

## Objetivo

Iniciar un proceso de deshidratación.

## Flujo

```mermaid
flowchart TD

A[Usuario]

A --> B[Seleccionar Materia Prima]

B --> C[Seleccionar Compostaje]

C --> D[Configurar Cantidad]

D --> E[Crear Registro]

E --> F[Proceso Activo]
```

---

# 🌡️ Caso de Uso: Monitorear Temperatura y Humedad

## Actores

* Cliente
* Arduino

## Objetivo

Visualizar variables del proceso.

```mermaid
sequenceDiagram

participant Arduino
participant Backend
participant Cliente

Arduino->>Backend: Temperatura

Arduino->>Backend: Humedad

Backend-->>Cliente: Datos actualizados
```

---

# 📊 Caso de Uso: Consultar Historial

## Actor

Cliente

## Objetivo

Consultar procesos realizados.

```mermaid
flowchart TD

A[Cliente]

A --> B[Consultar Historial]

B --> C[Aplicar Filtros]

C --> D[Visualizar Resultados]
```

---

# ⚙️ Caso de Uso: Controlar Deshidratador

## Actor

Cliente

## Objetivo

Encender o apagar el equipo.

```mermaid
sequenceDiagram

actor Cliente

participant Sistema
participant Arduino

Cliente->>Sistema: Encender Equipo

Sistema->>Arduino: Comando ON

Arduino-->>Sistema: Confirmación

Sistema-->>Cliente: Equipo Encendido
```

---

# 📄 Caso de Uso: Generar Reporte PDF

## Actor

Cliente

## Objetivo

Descargar información histórica.

```mermaid
flowchart TD

A[Cliente]

A --> B[Seleccionar Periodo]

B --> C[Generar Reporte]

C --> D[Exportar PDF]
```

---

# 🔄 Flujo Completo del Negocio

```mermaid
flowchart LR

A[Login]

--> B[Cliente]

--> C[Crear Proceso]

--> D[Deshidratador]

--> E[Arduino]

--> F[Sensor Temperatura]

--> G[Sensor Humedad]

--> H[Registro de Datos]

--> I[Historial]

--> J[Reporte PDF]
```

---

# 🎯 Casos de Uso Prioritarios del MVP

| Prioridad | Caso de Uso               |
| --------- | ------------------------- |
| 🔴 Alta   | Iniciar Sesión            |
| 🔴 Alta   | Gestionar Usuarios        |
| 🔴 Alta   | Gestionar Clientes        |
| 🔴 Alta   | Gestionar Materias Primas |
| 🔴 Alta   | Gestionar Compostajes     |
| 🔴 Alta   | Crear Proceso             |
| 🔴 Alta   | Consultar Historial       |
| 🟡 Media  | Monitorear Sensores       |
| 🟡 Media  | Controlar Deshidratador   |
| 🟢 Baja   | Generar PDF               |
| 🟢 Baja   | Notificaciones            |

---

# 🏁 Alcance del MVP

El MVP del sistema Wastech deberá permitir:

✅ Autenticación de usuarios

✅ Gestión de usuarios y clientes

✅ Configuración de materia prima

✅ Configuración de compostajes

✅ Creación de procesos de deshidratación

✅ Consulta de historial

✅ Recepción de datos IoT

✅ Visualización de temperatura y humedad

---

**Proyecto:** Wastech

**Versión:** 1.0

**Tipo de Documento:** Casos de Uso

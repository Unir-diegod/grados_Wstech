# Arquitectura del Sistema

## Descripción

Wastech utiliza una arquitectura cliente-servidor basada en IoT.

## Componentes

### Sensores

Capturan temperatura y humedad.

### ESP8266

Recibe los datos de los sensores y los envía al backend.

### Backend

Desarrollado en Spring Boot.

Responsabilidades:

- Procesamiento de datos.
- Gestión de usuarios.
- Generación de alertas.
- Exposición de API REST.

### Base de Datos

MySQL.

Responsabilidades:

- Almacenamiento de usuarios.
- Almacenamiento de lecturas.
- Registro de alertas.

### PWA

Interfaz para consulta y monitoreo.

## Diagrama

Sensores
↓
ESP8266
↓
Spring Boot API
↓
MySQL
↓
PWA
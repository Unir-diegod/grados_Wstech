# Modelo Entidad Relación

## Entidades Principales

### Usuario

- id
- nombre
- correo
- password

### Dispositivo

- id
- nombre
- estado

### Sensor

- id
- nombre
- tipo

### Lectura

- id
- temperatura
- humedad
- fecha

### Alerta

- id
- descripcion
- fecha

## Relaciones

Usuario 1:N Dispositivo

Dispositivo 1:N Sensor

Sensor 1:N Lectura

Lectura 1:N Alerta
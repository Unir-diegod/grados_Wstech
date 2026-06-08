# Entidades del Negocio

## Objetivo

Identificar las entidades principales que intervienen en el dominio del problema y que posteriormente serán utilizadas para el diseño de la base de datos y la arquitectura del sistema.

---

# Entidades Maestras

Las entidades maestras representan información relativamente estable dentro del sistema.

## Usuario

Representa las personas autorizadas para acceder a la plataforma.

### Atributos

* id
* nombre
* apellido
* correo
* contraseña
* rol
* estado

---

## Rol

Define los permisos asociados a cada usuario.

### Atributos

* id
* nombre
* descripcion

---

## DispositivoIoT

Representa los equipos encargados de recolectar información.

### Atributos

* id
* nombre
* tipo
* ubicacion
* estado
* fechaRegistro

---

## Sensor

Representa los sensores instalados en los dispositivos.

### Atributos

* id
* nombre
* tipo
* unidadMedida
* estado

---

# Entidades Transaccionales

Las entidades transaccionales almacenan eventos o registros generados por la operación del sistema.

## LecturaSensor

Registra los valores enviados por los sensores.

### Atributos

* id
* fechaHora
* temperatura
* humedad
* dispositivoId

---

## Alerta

Registra eventos generados por condiciones anormales.

### Atributos

* id
* fechaHora
* tipo
* descripcion
* estado

---

## Notificacion

Representa mensajes enviados a los usuarios.

### Atributos

* id
* fechaHora
* mensaje
* usuarioId

---

## Reporte

Representa documentos generados por el sistema.

### Atributos

* id
* fechaGeneracion
* tipo
* usuarioId

---

# Relaciones Principales

```text
Rol
 │
 └── Usuario
        │
        ├── Reporte
        ├── Notificacion
        │
        └── DispositivoIoT
                 │
                 ├── Sensor
                 │
                 ├── LecturaSensor
                 │
                 └── Alerta
```

---

# Clasificación

## Entidades Maestras

* Usuario
* Rol
* DispositivoIoT
* Sensor

## Entidades Transaccionales

* LecturaSensor
* Alerta
* Notificacion
* Reporte

---

# Conclusiones

Las entidades identificadas representan el núcleo funcional del sistema y constituyen la base para la construcción del modelo entidad-relación y el diccionario de datos que serán desarrollados en la fase de diseño.

# Diccionario de Datos - Wastech

## Información General

Sistema: Wastech

Motor de Base de Datos: MySQL

ORM: Hibernate / JPA

---

# Tabla: perfil

Descripción:

Almacena los roles del sistema.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| idperfil | BIGINT | PK | Identificador único |
| nombre | VARCHAR(50) | NOT NULL | Nombre del perfil |

### Valores esperados

- ADMINISTRADOR
- CLIENTE

---

# Tabla: usuario

Descripción:

Almacena las credenciales de acceso al sistema.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| idusuario | BIGINT | PK | Identificador único |
| nombre | VARCHAR | NOT NULL | Nombre |
| apellido | VARCHAR | NOT NULL | Apellido |
| usuario | VARCHAR | UNIQUE | Nombre de usuario |
| contrasena | VARCHAR(255) | NOT NULL | Contraseña cifrada |
| idperfil | BIGINT | FK | Perfil asociado |
| cedula_cliente | VARCHAR(20) | FK | Cliente asociado |

---

# Tabla: cliente

Descripción:

Información personal de los clientes.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| cedula | VARCHAR(20) | PK | Documento de identidad |
| nombre1 | VARCHAR(50) | NOT NULL | Primer nombre |
| nombre2 | VARCHAR(50) | NULL | Segundo nombre |
| apellido1 | VARCHAR(50) | NOT NULL | Primer apellido |
| apellido2 | VARCHAR(50) | NULL | Segundo apellido |
| telefono | VARCHAR(20) | NULL | Teléfono |
| direccion | VARCHAR(200) | NULL | Dirección |
| correo | VARCHAR(100) | NULL | Correo electrónico |
| id_registro | BIGINT | FK | Registro asociado |

---

# Tabla: arduino

Descripción:

Dispositivos Arduino registrados.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| id_arduino | BIGINT | PK | Identificador del dispositivo |
| nombre | VARCHAR(50) | NOT NULL | Nombre del dispositivo |
| modelo | VARCHAR(50) | NOT NULL | Modelo |

---

# Tabla: deshidratador

Descripción:

Equipos de deshidratación.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| id_deshidratador | BIGINT | PK | Identificador |
| calentador | BOOLEAN | NULL | Estado del calentador |
| id_arduino | BIGINT | FK | Arduino asociado |

---

# Tabla: tipo_sensor

Descripción:

Tipos de sensores soportados.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| id_tiposensor | BIGINT | PK | Identificador |
| nombre_sensor | VARCHAR(50) | NOT NULL | Tipo de sensor |

### Valores esperados

- TEMPERATURA
- HUMEDAD

---

# Tabla: sensores

Descripción:

Sensores instalados en el sistema.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| id_sensor | BIGINT | PK | Identificador |
| valor_lectura | DOUBLE | NULL | Última lectura |
| fecha_lectura | DATETIME | NULL | Fecha de lectura |
| id_tiposensor | BIGINT | FK | Tipo de sensor |
| id_arduino | BIGINT | FK | Arduino asociado |

---

# Tabla: resultado

Descripción:

Histórico de lecturas registradas.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| cod_resultado | BIGINT | PK | Identificador |
| fecha_inicio | DATETIME | NULL | Inicio |
| fecha_fin | DATETIME | NULL | Fin |
| valor | DOUBLE | NULL | Valor registrado |
| id_sensor | BIGINT | FK | Sensor asociado |

---

# Tabla: tipo_materia_prima

Descripción:

Materias primas procesadas.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| id_matep | BIGINT | PK | Identificador |
| nombre | VARCHAR(100) | NOT NULL | Nombre |
| temperatura | DOUBLE | NULL | Temperatura recomendada |

---

# Tabla: tipo_compostaje

Descripción:

Tipos de compostaje configurados.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| id_compostaje | BIGINT | PK | Identificador |
| compuestos | VARCHAR(200) | NOT NULL | Componentes |
| temperatura_limite | DOUBLE | NULL | Temperatura máxima |
| humedad_limite | DOUBLE | NULL | Humedad máxima |

---

# Tabla: registro

Descripción:

Proceso principal de deshidratación.

| Campo | Tipo | Restricciones | Descripción |
|---------|---------|---------|---------|
| id_registro | BIGINT | PK | Identificador |
| fecha_inicio | DATETIME | NULL | Inicio del proceso |
| fecha_fin | DATETIME | NULL | Fin del proceso |
| estado | VARCHAR(50) | NOT NULL | Estado actual |
| temperatura | DOUBLE | NULL | Temperatura registrada |
| humedad | DOUBLE | NULL | Humedad registrada |
| cantidad | DOUBLE | NULL | Cantidad procesada |
| id_deshidratador | BIGINT | FK | Equipo asociado |
| id_matep | BIGINT | FK | Materia prima |
| id_compostaje | BIGINT | FK | Compostaje asociado |

---

# Relaciones Principales

## Usuario → Perfil

Muchos usuarios pueden pertenecer a un perfil.

```text
Perfil 1 ---- N Usuario
```

## Usuario → Cliente

Un usuario puede estar asociado a un cliente.

```text
Cliente 1 ---- 1 Usuario
```

## Arduino → Sensor

```text
Arduino 1 ---- N Sensores
```

## Arduino → Deshidratador

```text
Arduino 1 ---- N Deshidratadores
```

## Registro → Deshidratador

```text
Deshidratador 1 ---- N Registros
```

## Registro → TipoMateriaPrima

```text
TipoMateriaPrima 1 ---- N Registros
```

## Registro → TipoCompostaje

```text
TipoCompostaje 1 ---- N Registros
```
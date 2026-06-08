# Casos de Prueba

## CP-001 - Inicio de Sesión

### Objetivo

Validar el acceso de usuarios registrados.

### Precondición

El usuario debe existir en la base de datos.

### Pasos

1. Ingresar correo válido.
2. Ingresar contraseña válida.
3. Presionar "Iniciar Sesión".

### Resultado Esperado

El sistema permite el acceso al dashboard.

---

## CP-002 - Registro de Usuario

### Objetivo

Validar la creación de usuarios.

### Pasos

1. Completar formulario.
2. Guardar información.

### Resultado Esperado

El usuario es almacenado correctamente.

---

## CP-003 - Registro de Lectura IoT

### Objetivo

Validar la recepción de datos enviados por sensores.

### Precondición

Dispositivo IoT activo.

### Pasos

1. Enviar lectura desde ESP8266.
2. Procesar información en la API.

### Resultado Esperado

La lectura se almacena en la base de datos.

---

## CP-004 - Generación de Alerta

### Objetivo

Validar alertas automáticas.

### Pasos

1. Enviar temperatura fuera del rango permitido.

### Resultado Esperado

Se genera una alerta automáticamente.

---

## CP-005 - Consulta de Historial

### Objetivo

Validar consulta de lecturas almacenadas.

### Pasos

1. Acceder al módulo de historial.
2. Seleccionar rango de fechas.

### Resultado Esperado

El sistema muestra los registros encontrados.

---

## CP-006 - Generación de Reporte

### Objetivo

Validar exportación de información.

### Pasos

1. Seleccionar período.
2. Generar reporte.

### Resultado Esperado

El sistema genera el documento correctamente.

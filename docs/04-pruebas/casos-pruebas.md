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

---

## CP-007 - Recuperación de Contraseña

### Objetivo

Validar el restablecimiento de contraseña.

### Pasos

1. Acceder a la opción de "Olvidé mi contraseña".
2. Ingresar correo registrado.
3. Seguir el enlace recibido.

### Resultado Esperado

El usuario puede crear una nueva contraseña.

---

## CP-008 - Almacenamiento de Medición IoT

### Objetivo

Validar que cada medición se guarda en la base de datos.

### Precondición

Dispositivo IoT activo y conectado.

### Pasos

1. Enviar lectura de sensor.
2. Verificar que la medición quede registrada.

### Resultado Esperado

La medición se almacena correctamente en la base de datos.

---

## CP-009 - Visualización en Tiempo Real

### Objetivo

Validar la visualización inmediata de lecturas de sensores.

### Pasos

1. Enviar datos desde sensores.
2. Revisar panel de monitoreo en la aplicación.

### Resultado Esperado

Los datos aparecen reflejados en tiempo real.

---

## CP-010 - Filtrado de Historial

### Objetivo

Validar el filtrado de registros por rango de fechas.

### Pasos

1. Acceder al módulo de historial.
2. Seleccionar fechas de inicio y fin.
3. Aplicar el filtro.

### Resultado Esperado

El sistema muestra solo los registros del rango seleccionado.

---

## CP-011 - Administración de Usuarios

### Objetivo

Validar la gestión de cuentas de usuario.

### Pasos

1. Editar datos de un usuario.
2. Eliminar un usuario.

### Resultado Esperado

Los cambios se aplican correctamente y el usuario se elimina si corresponde.

---

## CP-012 - Gestión de Dispositivos IoT

### Objetivo

Validar el registro, activación y desactivación de dispositivos.

### Pasos

1. Registrar un nuevo dispositivo.
2. Activar el dispositivo.
3. Desactivar el dispositivo.

### Resultado Esperado

El dispositivo queda registrado y cambia su estado según la acción.

---

## CP-013 - Consulta del Dashboard

### Objetivo

Validar la visualización de indicadores clave y alertas.

### Pasos

1. Acceder al panel de control.
2. Verificar métricas e indicadores.

### Resultado Esperado

El dashboard muestra el estado actual y las alertas del sistema.

---

## CP-014 - Notificaciones del Sistema

### Objetivo

Validar la generación de notificaciones y eventos.

### Pasos

1. Generar una alerta de sensor.
2. Verificar la notificación en la interfaz.

### Resultado Esperado

El sistema muestra la notificación al usuario.

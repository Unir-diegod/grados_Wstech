# Plan de Pruebas

## Objetivo

Validar el correcto funcionamiento de la plataforma Wastech, asegurando que los requisitos funcionales y no funcionales definidos sean cumplidos por el sistema.

---

# Alcance

Las pruebas incluyen:

* Autenticación de usuarios.
* Gestión de usuarios.
* Recepción de datos IoT.
* Registro de lecturas.
* Generación de alertas.
* Consulta de información.
* Generación de reportes.

---

# Tipos de Pruebas

## Pruebas Funcionales

Validan que las funcionalidades operen según los requisitos definidos.

### Ejemplos

* Inicio de sesión.
* Registro de usuarios.
* Consulta de lecturas.
* Generación de alertas.

---

## Pruebas de Integración

Validan la comunicación entre componentes.

### Componentes

* ESP8266 → API Spring Boot.
* API Spring Boot → MySQL.
* PWA → API REST.

---

## Pruebas de Seguridad

Validan mecanismos de protección.

### Verificaciones

* Acceso autenticado.
* Protección de rutas.
* Cifrado de contraseñas.
* Uso de HTTPS.

---

# Criterios de Aceptación

Se considerará satisfactoria una prueba cuando:

* El resultado obtenido coincida con el resultado esperado.
* No se generen errores críticos.
* La información sea almacenada correctamente.

---

# Herramientas Utilizadas

* Postman
* Navegador Web
* MySQL
* Consola del ESP8266
* Spring Boot Logs

---

# Evidencias

Las evidencias serán almacenadas en:

```text
docs/anexos/evidencias/
```

Incluyendo:

* Capturas de pantalla.
* Resultados de pruebas.
* Registros de ejecución.

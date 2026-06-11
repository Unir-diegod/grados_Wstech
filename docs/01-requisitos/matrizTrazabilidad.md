# Matriz de Trazabilidad

## Necesidad → Requisito Funcional → Historia de Usuario → Caso de Uso

### Objetivo

La matriz de trazabilidad permite verificar que cada necesidad identificada en el proyecto se encuentra cubierta por uno o varios requisitos funcionales, historias de usuario y casos de uso, garantizando la alineación entre los objetivos del negocio y la implementación del sistema.

---

## Matriz de Trazabilidad

| ID Necesidad | Necesidad                                      | ID RF | Requisito Funcional                                        | ID HU | Historia de Usuario                                                                          | ID CU | Caso de Uso                 |
| ------------ | ---------------------------------------------- | ----- | ---------------------------------------------------------- | ----- | -------------------------------------------------------------------------------------------- | ----- | --------------------------- |
| N-04         | Gestión de usuarios                            | RF-001 | Permitir el registro de usuarios                            | HU-001 | Como usuario, quiero registrarme para acceder al sistema                                    | CU-03 | Registrar Usuario           |
| N-04         | Gestión de usuarios                            | RF-002 | Permitir el inicio de sesión mediante correo y contraseña    | HU-002 | Como usuario, quiero iniciar sesión con mi correo y contraseña                              | CU-01 | Iniciar Sesión              |
| N-04         | Gestión de usuarios                            | RF-003 | Permitir la recuperación de contraseña                      | HU-003 | Como usuario, quiero recuperar mi contraseña cuando la olvide                               | CU-02 | Recuperar Contraseña        |
| N-01         | Monitoreo en tiempo real                       | RF-004 | Registrar lecturas de temperatura desde sensores IoT        | HU-004 | Como usuario, quiero registrar lecturas de temperatura de sensores IoT                     | CU-05 | Registrar Lectura           |
| N-01         | Monitoreo en tiempo real                       | RF-005 | Registrar lecturas de humedad desde sensores IoT            | HU-005 | Como usuario, quiero registrar lecturas de humedad de sensores IoT                         | CU-05 | Registrar Lectura           |
| N-02         | Centralización de la información               | RF-006 | Almacenar cada medición en la base de datos                 | HU-006 | Como usuario, quiero almacenar cada medición en la base de datos                           | CU-05 | Registrar Lectura           |
| N-01         | Monitoreo en tiempo real                       | RF-007 | Mostrar en tiempo real los datos capturados por los sensores | HU-007 | Como usuario, quiero ver los datos del sensor en tiempo real                               | CU-07 | Monitorear Temperatura y Humedad |
| N-03         | Alertas tempranas                              | RF-008 | Generar alertas cuando la temperatura supere los límites     | HU-008 | Como usuario, quiero recibir alertas cuando la temperatura salga de rango                  | CU-08 | Generar Alerta              |
| N-03         | Alertas tempranas                              | RF-009 | Generar alertas cuando la humedad esté fuera de rango       | HU-009 | Como usuario, quiero recibir alertas cuando la humedad sea anómala                         | CU-08 | Generar Alerta              |
| N-05         | Visualización histórica                        | RF-010 | Permitir consultar el historial de mediciones               | HU-010 | Como usuario, quiero consultar el historial de mediciones                                 | CU-06 | Consultar Historial         |
| N-05         | Visualización histórica                        | RF-011 | Permitir filtrar información por rango de fechas            | HU-011 | Como usuario, quiero filtrar información por rango de fechas                              | CU-06 | Consultar Historial         |
| N-06         | Generación de reportes                         | RF-012 | Generar reportes de monitoreo                               | HU-012 | Como usuario, quiero generar reportes de monitoreo                                        | CU-09 | Generar Reportes            |
| N-06         | Generación de reportes                         | RF-013 | Exportar reportes en formato PDF                            | HU-013 | Como usuario, quiero exportar reportes en formato PDF                                     | CU-09 | Generar Reportes            |
| N-04         | Gestión de usuarios                            | RF-014 | Permitir la administración de usuarios                      | HU-014 | Como administrador, quiero administrar usuarios                                           | CU-04 | Gestionar Usuarios          |
| N-03         | Alertas tempranas                              | RF-015 | Registrar eventos y notificaciones generadas por el sistema | HU-015 | Como usuario, quiero registrar eventos y notificaciones del sistema                      | CU-13 | Notificaciones del Sistema  |
| N-05         | Visualización histórica                        | RF-016 | Visualizar estadísticas del proceso de compostaje           | HU-016 | Como usuario, quiero visualizar estadísticas del proceso de compostaje                    | CU-10 | Consultar Dashboard         |
| N-01         | Monitoreo en tiempo real                       | RF-017 | Consultar el estado actual de cada dispositivo IoT          | HU-017 | Como usuario, quiero consultar el estado actual de cada dispositivo IoT                   | CU-07 | Monitorear Temperatura y Humedad |
| N-02         | Centralización de la información               | RF-018 | Registrar nuevos dispositivos IoT                           | HU-018 | Como administrador, quiero registrar nuevos dispositivos IoT                            | CU-11 | Gestionar Dispositivos IoT  |
| N-02         | Centralización de la información               | RF-019 | Activar o desactivar dispositivos registrados               | HU-019 | Como administrador, quiero activar o desactivar dispositivos IoT                          | CU-12 | Gestionar Dispositivos IoT  |
| N-05         | Visualización histórica                        | RF-020 | Mostrar un panel de control con indicadores clave           | HU-020 | Como usuario, quiero ver un panel de control con indicadores clave                       | CU-10 | Consultar Dashboard         |

---

## Relación de Cobertura

### Necesidad N-01

* RF-004 → HU-004 → CU-05
* RF-005 → HU-005 → CU-05
* RF-007 → HU-007 → CU-07
* RF-017 → HU-017 → CU-07

### Necesidad N-02

* RF-006 → HU-006 → CU-05
* RF-018 → HU-018 → CU-11
* RF-019 → HU-019 → CU-12

### Necesidad N-03

* RF-008 → HU-008 → CU-08
* RF-009 → HU-009 → CU-08
* RF-015 → HU-015 → CU-13

### Necesidad N-04

* RF-001 → HU-001 → CU-03
* RF-002 → HU-002 → CU-01
* RF-003 → HU-003 → CU-02
* RF-014 → HU-014 → CU-04

### Necesidad N-05

* RF-010 → HU-010 → CU-06
* RF-011 → HU-011 → CU-06
* RF-016 → HU-016 → CU-10
* RF-020 → HU-020 → CU-10

### Necesidad N-06

* RF-012 → HU-012 → CU-09
* RF-013 → HU-013 → CU-09

---

## Observaciones

* Las necesidades N-007 y N-008 son de carácter no funcional y están cubiertas por el documento `requisitos-no-funcionales.md`.
* Cada necesidad funcional debe estar asociada al menos a un requisito funcional.
* Cada requisito funcional debe estar respaldado por una historia de usuario.
* Cada historia de usuario debe estar implementada mediante uno o varios casos de uso.
* La matriz permite validar la cobertura completa de los requerimientos del proyecto y facilita futuras auditorías, pruebas y mantenimientos.

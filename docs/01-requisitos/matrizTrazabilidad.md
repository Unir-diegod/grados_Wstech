# Matriz de Trazabilidad

## Necesidad → Requisito Funcional → Historia de Usuario → Caso de Uso

### Objetivo

La matriz de trazabilidad permite verificar que cada necesidad identificada en el proyecto se encuentra cubierta por uno o varios requisitos funcionales, historias de usuario y casos de uso, garantizando la alineación entre los objetivos del negocio y la implementación del sistema.

---

## Matriz de Trazabilidad

| ID Necesidad | Necesidad                                      | ID RF | Requisito Funcional                                        | ID HU | Historia de Usuario                                                                          | ID CU | Caso de Uso          |
| ------------ | ---------------------------------------------- | ----- | ---------------------------------------------------------- | ----- | -------------------------------------------------------------------------------------------- | ----- | -------------------- |
| N-01         | Gestionar el acceso seguro al sistema          | RF-01 | Permitir el inicio de sesión mediante credenciales válidas | HU-01 | Como usuario, quiero iniciar sesión para acceder a las funcionalidades del sistema           | CU-01 | Iniciar Sesión       |
| N-01         | Gestionar el acceso seguro al sistema          | RF-02 | Permitir la recuperación de contraseña                     | HU-02 | Como usuario, quiero recuperar mi contraseña para volver a acceder a mi cuenta               | CU-02 | Recuperar Contraseña |
| N-02         | Administrar usuarios del sistema               | RF-03 | Registrar nuevos usuarios                                  | HU-03 | Como administrador, quiero registrar usuarios para otorgar acceso al sistema                 | CU-03 | Registrar Usuario    |
| N-02         | Administrar usuarios del sistema               | RF-04 | Modificar información de usuarios                          | HU-04 | Como administrador, quiero actualizar datos de usuarios para mantener la información vigente | CU-04 | Gestionar Usuarios   |
| N-03         | Gestionar información del sistema              | RF-05 | Crear registros                                            | HU-05 | Como usuario, quiero crear registros para almacenar información                              | CU-05 | Crear Registro       |
| N-03         | Gestionar información del sistema              | RF-06 | Consultar registros                                        | HU-06 | Como usuario, quiero consultar registros para visualizar información almacenada              | CU-06 | Consultar Registro   |
| N-03         | Gestionar información del sistema              | RF-07 | Actualizar registros                                       | HU-07 | Como usuario, quiero modificar registros para mantener la información actualizada            | CU-07 | Actualizar Registro  |
| N-03         | Gestionar información del sistema              | RF-08 | Eliminar registros                                         | HU-08 | Como usuario, quiero eliminar registros que ya no sean necesarios                            | CU-08 | Eliminar Registro    |
| N-04         | Obtener información para la toma de decisiones | RF-09 | Generar reportes                                           | HU-09 | Como usuario, quiero generar reportes para analizar la información del sistema               | CU-09 | Generar Reportes     |
| N-05         | Monitorear la operación del sistema            | RF-10 | Visualizar indicadores y métricas                          | HU-10 | Como administrador, quiero visualizar métricas para supervisar el funcionamiento del sistema | CU-10 | Consultar Dashboard  |

---

## Relación de Cobertura

### Necesidad N-01

* RF-01 → HU-01 → CU-01
* RF-02 → HU-02 → CU-02

### Necesidad N-02

* RF-03 → HU-03 → CU-03
* RF-04 → HU-04 → CU-04

### Necesidad N-03

* RF-05 → HU-05 → CU-05
* RF-06 → HU-06 → CU-06
* RF-07 → HU-07 → CU-07
* RF-08 → HU-08 → CU-08

### Necesidad N-04

* RF-09 → HU-09 → CU-09

### Necesidad N-05

* RF-10 → HU-10 → CU-10

---

## Observaciones

* Cada necesidad debe estar asociada al menos a un requisito funcional.
* Cada requisito funcional debe estar respaldado por una historia de usuario.
* Cada historia de usuario debe estar implementada mediante uno o varios casos de uso.
* La matriz permite validar la cobertura completa de los requerimientos del proyecto y facilita futuras auditorías, pruebas y mantenimientos.

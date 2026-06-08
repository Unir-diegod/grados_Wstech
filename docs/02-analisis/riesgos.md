# Análisis de Riesgos

## Objetivo

Identificar, evaluar y proponer acciones de mitigación frente a los riesgos que puedan afectar el desarrollo, implementación y operación del sistema Wastech.

---

# Matriz de Riesgos

| ID    | Riesgo                                     | Probabilidad | Impacto  | Nivel   |
| ----- | ------------------------------------------ | ------------ | -------- | ------- |
| R-001 | Fallo de sensores IoT                      | Alta         | Alta     | Crítico |
| R-002 | Pérdida de conectividad de red             | Media        | Alta     | Alto    |
| R-003 | Pérdida de información en la base de datos | Baja         | Muy Alta | Alto    |
| R-004 | Acceso no autorizado al sistema            | Media        | Muy Alta | Crítico |
| R-005 | Lecturas incorrectas de sensores           | Media        | Alta     | Alto    |
| R-006 | Fallos de alimentación eléctrica           | Media        | Alta     | Alto    |
| R-007 | Retrasos en el desarrollo                  | Media        | Media    | Medio   |
| R-008 | Incompatibilidad entre componentes         | Baja         | Alta     | Medio   |
| R-009 | Saturación del servidor                    | Baja         | Alta     | Medio   |
| R-010 | Errores de software en producción          | Media        | Alta     | Alto    |

---

# Plan de Mitigación

## R-001 - Fallo de sensores

**Mitigación:**

* Mantenimiento preventivo.
* Pruebas periódicas.
* Sustitución rápida de componentes.

---

## R-002 - Pérdida de conectividad

**Mitigación:**

* Reintentos automáticos.
* Almacenamiento temporal local.
* Monitoreo de red.

---

## R-003 - Pérdida de información

**Mitigación:**

* Copias de seguridad automáticas.
* Replicación de base de datos.
* Restauración documentada.

---

## R-004 - Acceso no autorizado

**Mitigación:**

* HTTPS.
* Contraseñas cifradas.
* Control de roles.
* Registro de auditoría.

---

## R-005 - Datos incorrectos

**Mitigación:**

* Validación de rangos.
* Calibración de sensores.
* Verificación periódica.

---

# Riesgos Técnicos Prioritarios

1. Seguridad de la información.
2. Fallo de sensores.
3. Integridad de datos.
4. Disponibilidad de la plataforma.
5. Conectividad IoT.

---

# Conclusiones

Los riesgos más relevantes se encuentran asociados a la infraestructura IoT, la seguridad de la información y la disponibilidad de los servicios que soportan la plataforma.

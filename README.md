# 🌱 Wastech

## Sistema IoT para el monitoreo inteligente de residuos orgánicos

---

## 🚀 ¿Qué es Wastech?

**Wastech** es una solución tecnológica basada en **IoT + PWA + Backend en Spring Boot** diseñada para monitorear en tiempo real el comportamiento de residuos orgánicos durante procesos de compostaje.

El sistema captura variables como:

* 🌡️ Temperatura
* 💧 Humedad

y las transforma en información útil para la toma de decisiones, alertas automáticas y análisis histórico.

---

## 🎯 Problema que resuelve

La gestión de residuos orgánicos suele ser:

* Manual
* Poco monitoreada
* Sin trazabilidad de datos
* Dependiente de observación humana

Esto genera:

* Pérdida de control del proceso de compostaje
* Resultados inconsistentes
* Falta de datos para análisis ambiental

---

## 💡 Solución propuesta

Wastech integra tres capas:

### 🧠 Capa IoT

* Sensores (temperatura y humedad)
* Microcontrolador ESP8266
* Envío de datos en tiempo real

### ⚙️ Backend

* API REST en Spring Boot
* Procesamiento de datos
* Gestión de usuarios, lecturas y alertas

### 📱 Frontend (PWA)

* Dashboard en tiempo real
* Historial de datos
* Visualización de alertas
* Acceso multiplataforma

---

## 🏗️ Arquitectura general

```text
Sensores IoT
   ↓
ESP8266
   ↓
API Spring Boot
   ↓
Base de Datos (MySQL)
   ↓
PWA Dashboard
```

---

## 🧩 Módulos principales

* 🔐 Autenticación y seguridad
* 👤 Gestión de usuarios
* 📡 Recepción de datos IoT
* 📊 Visualización de métricas
* ⚠️ Sistema de alertas
* 📈 Historial de lecturas
* 📄 Generación de reportes

---

## 🛠️ Tecnologías utilizadas

### Backend

* Java
* Spring Boot
* Spring Security
* JPA / Hibernate

### Frontend

* HTML5 / CSS3 / JavaScript
* PWA (Progressive Web App)

### IoT

* ESP8266
* Sensores de temperatura y humedad

### Base de datos

* MySQL

---

## 📁 Estructura del proyecto

```text
docs/
 ├── 01-requisitos
 ├── 02-analisis
 ├── 03-diseno
 ├── 04-pruebas
src/
 ├── backend
 ├── frontend
 └── iot
```

---

## 📊 Estado del proyecto

* ✔ Requisitos definidos
* ✔ Arquitectura diseñada
* ✔ Backend en desarrollo
* ✔ Integración IoT en progreso
* ⏳ Pruebas en validación

---

## 🔐 Seguridad

* Autenticación con JWT
* Contraseñas cifradas (BCrypt)
* Comunicación HTTPS
* Control de roles

---

## 🧪 Pruebas

El sistema incluye:

* Pruebas funcionales
* Pruebas de integración
* Validación de sensores IoT
* Casos de prueba documentados

---

## 📌 Objetivo del proyecto

Desarrollar un sistema inteligente capaz de **automatizar y optimizar el monitoreo de residuos orgánicos**, aportando datos confiables para mejorar procesos ambientales.

---

## 👨‍💻 Autor

Proyecto académico de ingeniería de sistemas
Desarrollo de software + IoT + arquitectura web

---

## ⚠️ Nota

Este proyecto está en fase de desarrollo académico y puede evolucionar en su arquitectura y funcionalidades.

---

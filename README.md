# 📁 Microservicio de Legajos - Sistema de Gestión

Este microservicio forma parte del sistema de gestión de legajos y se encarga de la administración de expedientes asociados a usuarios autenticados.

---

## 🧱 Responsabilidad del servicio

Este servicio gestiona:

- Creación de legajos
- Consulta de legajos
- Listado general de legajos
- Asociación de legajos a usuarios
- Exposición de API REST para consumo del frontend

---

## ⚙️ Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security (JWT validation)
- Oracle Database XE
- Maven

---

## 🔐 Seguridad

El microservicio está protegido mediante JWT.

- Todas las rutas requieren token válido
- El token es validado contra el microservicio de usuarios
- Acceso controlado por autenticación stateless

---

## 📦 Endpoints principales

### 📌 Obtener todos los legajos


---

### 📌 Crear legajo


Ejemplo:

```json id="leg1"
{
  "nombre": "Legajo Ejemplo",
  "descripcion": "Descripción del legajo"
}

GET /api/legajos/{id}

🔗 Integración

Este microservicio se integra con:

👤 Microservicio de usuarios (autenticación JWT)
🖥️ Frontend Angular (consumo REST API)
🗂️ Casilleros service (relación de contexto)

👨‍💻 Autor

Desarrollado por CrisDebug
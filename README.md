## 🎟️ Ticket Management API
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

API REST desarrollada con **Spring Boot** para la gestión de tickets de soporte.

Este proyecto forma parte de mi **portfolio como Backend Developer Junior**, donde demuestro buenas prácticas en arquitectura REST, validación de datos y manejo de errores.

## 🟩 Sobre el proyecto

El proyecto ha sido creado con el objetivo de aprender el uso de **Spring Boot** y **Maven**.

Durante el desarrollo he trabajado con:

- Arquitectura REST en capas
- Uso de DTOs para desacoplar la API
- Validación de datos de entrada
- Manejo global de excepciones
- Persistencia de datos con JPA
- Documentación automática con OpenAPI (Swagger)

## 🟩 Qué aprendí con este proyecto

- Estructurar correctamente una API REST profesional
- Organizar dependencias y ciclo de vida del proyecto con Maven
- Implementar validaciones robustas
- Centralizar el manejo de errores
- Documentar una API con Swagger / OpenAPI

## 🟩 Tecnologías utilizadas

- Java 17  
- Spring Boot 3  
- Spring Web (REST)  
- Spring Data JPA  
- Bean Validation  
- PostgreSQL  
- Swagger / OpenAPI (springdoc)  
- Maven  
- Lombok  

## 🟩 Arquitectura

El proyecto sigue una **arquitectura en capas**:

- **Controller** → Manejo de peticiones HTTP  
- **Service** → Lógica de negocio  
- **Repository** → Acceso a datos  
- **DTOs** → Transferencia segura de datos  
- **Global Exception Handler** → Manejo centralizado de errores  

## 🟩 Funcionalidades

- Crear tickets de soporte  
- Obtener todos los tickets  
- Obtener un ticket por ID  
- Actualizar un ticket completo  
- Actualizar solo el estado del ticket  
- Eliminar tickets  
- Validación de datos de entrada  
- Manejo global de errores  
- Documentación automática con Swagger  

## 🟩 Endpoints principales

| Método | Endpoint | Descripción |
|------|---------|------------|
| GET | `/api/tickets` | Obtener todos los tickets |
| GET | `/api/tickets/{id}` | Obtener ticket por ID |
| POST | `/api/tickets` | Crear un nuevo ticket |
| PUT | `/api/tickets/{id}` | Actualizar un ticket completo |
| PATCH | `/api/tickets/{id}/status` | Actualizar estado del ticket |
| DELETE | `/api/tickets/{id}` | Eliminar un ticket |

---

## 🟩 Ejemplo de creación de ticket

###  Request

**POST** `/api/tickets`

```json
{
  "title": "Error al iniciar sesión",
  "description": "El usuario no puede acceder a la aplicación",
  "status": "OPEN"
}
```
### Response

**Status:** `201 Created`

```json
{
  "id": 1,
  "title": "Error al iniciar sesión",
  "description": "El usuario no puede acceder a la aplicación",
  "status": "OPEN"
}
```

### Manejo de errores
Ticket no encontrado

**Status:** `404 Not Found`
```json
{
  "error": "Ticket no encontrado con id: 5"
}
```

### Validaciones incorrectas

Las validaciones devuelven errores detallados por campo cuando los datos de entrada no cumplen las restricciones definidas.

## 🟩 Documentación Swagger

Una vez arrancada la aplicación, la documentación interactiva está disponible en:

http://localhost:8080/swagger-ui.html


Desde allí puedes probar todos los endpoints directamente.

## 🟩 Cómo ejecutar el proyecto
### Requisitos

- Java 17
- Maven
- PostgreSQL

### Pasos
- git clone https://github.com/JJHernan-dev/ticket-management-backend.git
- cd ticket-management-backend
- mvn spring-boot:run


Luego, configura tu base de datos en: application.yml o application.properties

## 🟩 Configuración

La aplicación utiliza variables de entorno para la conexión a la base de datos:

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

## 👨‍💻 Autor

Proyecto desarrollado por Juan Jesús González Hernández
Backend Developer Junior

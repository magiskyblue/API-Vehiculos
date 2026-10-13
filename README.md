# AlquilaYa S.A. - API REST y Panel de Administración

## Descripción de la API
La API de "AlquilaYa S.A." es un sistema desarrollado bajo una Arquitectura Orientada a Servicios (SOA) diseñado para modernizar las operaciones de alquiler de vehículos. Permite a clientes y aplicaciones de terceros interactuar con el inventario de la flota en tiempo real. El sistema gestiona el registro de oficinas, el control de disponibilidad de vehículos, el directorio de clientes y el ciclo de vida completo de las reservas (alquileres), calculando automáticamente los costos y actualizando la disponibilidad. Además, incluye un panel web de administración integrado (Dashboard SPA).

## Tecnologías utilizadas
* **Lenguaje:** Java 21
* **Framework Backend:** Spring Boot 3 (Arquitectura MVC)
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL
* **Gestor de Dependencias:** Maven
* **Frontend (Panel de Administración):** HTML5, Bootstrap 5, Vanilla JavaScript (Fetch API), SweetAlert2
* **Documentación:** OpenAPI / Swagger UI

## Pasos de instalación y ejecución
1. **Clonar el repositorio:**
   `git clone <https://github.com/magiskyblue/API-Vehiculos.git>`
2. **Preparar la base de datos:**
   Abre MySQL (Workbench o terminal) y crea la base de datos principal:
   `CREATE DATABASE alquilaya_db;`
3. **Configurar el entorno:**
   Abre el proyecto en tu IDE (VS Code o IntelliJ) y asegúrate de que el archivo `src/main/resources/application.properties` contenga las variables de entorno adecuadas, sin credenciales quemadas en el código público.
4. **Ejecutar la aplicación:**
   Abre la terminal en la raíz del proyecto y ejecuta el Wrapper de Maven:
   `./mvnw spring-boot:run`
5. **Acceso al sistema:**
   * **Panel de Administración (Frontend):** `http://localhost:8081`
   * **Documentación Swagger UI:** `http://localhost:8081/swagger-ui/index.html`

## Variables de entorno necesarias
Para evitar subir credenciales reales al repositorio y mantener la seguridad, el sistema utiliza variables de entorno en su configuración (`application.properties`). Deben configurarse en el sistema local antes de ejecutar:

* `DB_URL`: Ruta de conexión a la base de datos (Por defecto: `jdbc:mysql://localhost:3306/alquilaya_db`)
* `DB_USERNAME`: Usuario de la base de datos MySQL (Ej. `root`).
* `DB_PASSWORD`: Contraseña del usuario de la base de datos MySQL.

## Listado de endpoints
La API consume y produce datos en formato JSON a través del puerto `8081`. 

### Vehículos (Flota)
* `GET /api/vehiculos` - Devuelve la lista de todos los vehículos y sus estados.
* `POST /api/vehiculos` - Registra un nuevo vehículo en una sucursal específica.

### Clientes
* `GET /api/clientes` - Obtiene el directorio de todos los clientes registrados.
* `POST /api/clientes` - Registra un nuevo cliente validando licencia y correo.

### Alquileres (Reservas)
* `GET /api/alquileres` - Muestra el historial de todas las reservas y sus cálculos.
* `POST /api/alquileres` - Genera una nueva reserva, calcula el total a pagar basándose en la tarifa diaria y los días reservados, y marca el vehículo como "Alquilado".

### Oficinas
* `GET /api/oficinas` - Obtiene las sucursales disponibles para asignar vehículos.

## 🚀 Ejemplos de peticiones y respuestas

### Ejemplo 1: Crear una reserva (POST /api/alquileres)

**Petición (JSON Body):**
```json
{
  "vehiculo": { "id": 2 },
  "cliente": { "id": 1 },
  "fechaInicio": "2026-10-15",
  "fechaFin": "2026-10-20"
}
```

**Respuesta Exitosa (200 OK):**
```json
{
    "id": 1,
    "vehiculo": { 
        "id": 2, 
        "marca": "Nissan", 
        "modelo": "Versa", 
        "tarifaDiaria": 750.0,
        "estado": "Alquilado" 
    },
    "cliente": { 
        "id": 1, 
        "nombre": "Juan", 
        "apellido": "Pérez" 
    },
    "fechaInicio": "2026-10-15",
    "fechaFin": "2026-10-20",
    "precioTotal": 3750.0,
    "estado": "Activo"
}
```

### Ejemplo 2: Registrar un nuevo cliente (POST /api/clientes)

**Petición (JSON Body):**
```json
{
  "nombre": "María",
  "apellido": "Gómez",
  "email": "maria.gomez@email.com",
  "licencia": "XYZ98765",
  "telefono": "555-1234"
}
```

**Respuesta Exitosa (200 OK):**
```json
{
  "id": 2,
  "nombre": "María",
  "apellido": "Gómez",
  "email": "maria.gomez@email.com",
  "licencia": "XYZ98765",
  "telefono": "555-1234"
}
```
# API Rest - Inventario de productos

API REST completa para gestionar el inventario de una tienda, construida con Spring Boot, gradel, Postgres y dockerizada.

## Tecnologias
- Spring Boot 4.0.5
- Gradle
- PostgreSQL
- JPA -hibernate
- Docker, Docker compose

## Ejecución local
```bash
#1. Clonar el repositorio
git clone https://github.com/Kazzv/inventario.git

#2. Entrar a la carpeta inventario
cd inventario

#3. Ejecutar con Docker Compose
docker compose up --build 
```
## Endpoints
| Método  | Endpoint            | Descripcion
| ------  | ---------           | ------------
| GET     | /api/productos      | Lista todos los productos
| GET     | /api/productos/{id} | Obtener producto por ID
| POST    | /api/productos      | Crear nuevo producto
| PUT     | /api/productos/{id} | Actualizar producto por ID
| DELETE  | /api/productos/{id} | Eliminar producto por ID

Base de datos: postgres (puerto 5432)
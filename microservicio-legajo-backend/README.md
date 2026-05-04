Infraestructura MicroDocs:

- Oracle XE en Docker (gvenzl/oracle-xe:21-slim)
- Casilleros-service (8082)
- Legajos-service (8083)

## Usuarios BD
- USUARIO_CAS → Casilleros
- USUARIO_LEG → Legajos
Password: 1234

## Inicialización Oracle
Se ejecuta desde ./oracle-init:
- crea esquemas
- asigna permisos

## Reglas arquitectura
- cada microservicio tiene su schema
- no hay FK entre microservicios
- comunicación por REST

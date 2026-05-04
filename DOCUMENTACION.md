## ✅ Actualización de esquema (Microservicio Usuarios / APP_ADMIN)

Se agregó soporte de roles directamente en la tabla `USUARIO` para cumplir con el requisito de **mínimo 2 tipos de usuario con privilegios distintos (ADMIN / USER)**.

### Script ejecutado en Oracle

```sql
ALTER TABLE USUARIO ADD ROL VARCHAR2(20) DEFAULT 'USER' NOT NULL;

UPDATE USUARIO SET ROL='ADMIN' WHERE EMAIL='admin@test.com';

COMMIT;

SELECT ID_USUARIO, EMAIL, ROL FROM USUARIO;

salida:

| ID_USUARIO | EMAIL                                             | ROL   |
| ---------: | ------------------------------------------------- | ----- |
|          2 | [archivero@test.com](mailto:archivero@test.com)   | USER  |
|          4 | [encriptado@test.com](mailto:encriptado@test.com) | USER  |
|          1 | [admin@test.com](mailto:admin@test.com)           | ADMIN |

    
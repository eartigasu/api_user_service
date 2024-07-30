# Servicio de Creación de Usuarios

Desarrollo de microservicio para test de NTTDATA. El desarrollo consta de la exposición de un endpoint para la creación de un usuario con ciertas restricciones. Para la exposición y documentación del servicio, la API cuenta con el uso de SWAGGER.
*Desarrollado con la versión Java 21.*

El servicio cuenta con:
   - La exposición de un solo endpoint (/api/users) para la creación de usuarios, el cual se persiste en la base de datos junto con sus números telefónicos si están informados.
   - Varios casos de prueba automatizados (6) que intentan cubrir los casos de uso solicitados.
   - La generación de un Token JWT el cual se persiste en la base de datos.
   - Validación de formato de contraseña segun regex configurado en application.properties
   - Validación de formato de email y campos obligatorios.
   - Validación de usuario con email ya registrado.
   - Uso de Swagger para la documentación y pruebas de la API.

## Documentación Adjunta
Se adjunta en la carpeta raíz el archivo .sql para la creación de las tablas para la base de datos y también un archivo .png con el diagrama de la solución.

## Instalación del Proyecto
    **Consideraciones: Tener instalado Java y Maven**
        1. **Clonar Repositorio:**
            Clonar desde la siguiente URL:
            https://github.com/eartigasu/api_user_service.git

        2. **Base de Datos (Opcional):**
            El proyecto cuenta con una base de datos H2 que se inicia junto con Spring Boot. Si se desea montar físicamente dicha base de datos, se adjunta un script para la generación de las tablas.
            - Si se desea montar el script en otra base de datos, se recomienda hacer las modificaciones necesarias en el archivo application.properties.

        3. **Arrancar la Aplicación:**
            Navegar hasta la carpeta donde se ha clonado el repositorio, abrir la consola y ejecutar lo siguiente:
            - mvn clean install
            - mvn spring-boot:run (esto debería arrancar la aplicación completamente con la base de datos embebida)
   
## Uso de la API
1. **Acceder a la Aplicación:**
    La aplicación estará disponible en http://localhost:8080/api/users.

3. **Probar la API:**
    Utilice herramientas como Postman o curl para interactuar con la API. También puede hacer uso de Swagger.

4. **Probar desde Swagger:**
    Ingresar a la siguiente URL: http://localhost:8080/swagger-ui/index.html#/
    En esta URL se encontrará el endpoint de creación de usuarios con la información del microservicio.
  
## Para mayor información de la API, respecto a requests, responses y códigos de respuesta, se puede consultar desde Swagger http://localhost:8080/swagger-ui/index.html#/

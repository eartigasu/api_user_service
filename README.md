# Servicio de Creación de Usuarios

Desarrollo de microservicio para test de NTTDATA. El desarrollo consta de la exposicion de un endpoint para la creacion de un usuario con ciertas restricciones.
Para le exposicion y documentacion de servicio la api cuenta con el uso de SWAGGER.
*Desarrollado con la version Java 21.*

## Documentacion Adjunta
Se adjunta en la carpeta raíz el .sql de creacion de la bd y tambien el .png con el diagrama de la solución.

## Instalación del Proyecto
    ** Consideracions: Tener instalado Java y Maven
        1. **Clonar Repositorio:**
            Clonar desde la siguiente url
            https://github.com/eartigasu/api_user_service.git

        2. **Base Datos(Opcional):**
            El proyecto cuenta con BD H2 que arranca junto con springboot, si se desea montar fisicamente dicha base de datos, se adjunta un script con la generacion de las tablas.
            - Si se desea montar el script en otra BD, se recomienda hacer las modificaciones necesarias en el application.properties


        3. **Arrancar la Aplicacion**
            Navegar hasta la carpeta donde se ha clonado el repositorio, abrir la consola y ejecutar lo siguiente:
            - mvn clean install
            - mvn spring-boot:run (esto deberia arrancar la app completamente con la bd embebida)
   
## Uso de la API
1. **Acceder a la Aplicación:**
    La aplicación estará disponible en http://localhost:8080/api/users.

3. **Probar la API:**
    Utilice herramientas como Postman o curl para interactuar con la API. Tambien puede hacer uso de Swagger

4. **Probar desde Swagger**
    Ingresar a la siguiente url: http://localhost:8080/swagger-ui/index.html#/
    En esta url se encontrara el endpoint de creacion de usuario con la información del microservicio

5. **Crear Usuario:**
    - Endpoint: `http://localhost:8080/api/users`
    - Método: `POST`
    - Content-Type: `application/json`
  
## Para mayor información de la API respecto, respecto a request, response y codigos de respuesta, se puede consultar desde Swagger http://localhost:8080/swagger-ui/index.html#/
    

    





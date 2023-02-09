# tokenExercise
# 1. Pedir token a partir de un servicio de autenticación
Dado este servicio de autenticación:
Servicio de autenticación que escucha en el puerto 8080 y consta del siguiente endpoint:

cURL:
curl --location --request POST 'http://localhost:8080/token' \
--header 'Content-Type: application/json' \
--data-raw '{
"username":"auth-vivelibre",
"password":"password"
}'

Docker: docker pull skeet15/auth-vivelibre.

Realizar un servicio Spring Boot que llame a este endpoint y obtenga el token de la
respuesta. Este endpoint devolverá el token junto con la fecha en la que se pidió:



GET http://localhost:8081/get-token

Cuerpo de la respuesta:

{
"auth-vivelibre-token": "string",
"date": "February 21, 2018"
}


El proyecto Spring Boot deberá ser presentado en un repositorio Git. Además, se
deberá empaquetar el servicio en un docker. De manera que se proporcionarán dosPrueba técnica Backend ViveLibre 2
links, uno al repositorio Git y otro al DockerHub donde se encuentre el contenedor

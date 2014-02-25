# Technology Stack

The project uses the following technologies:
- **java**: Java 7
- **web server**: Tomcat 7
- **web/REST**: Spring 3, RestEasy 2
- **view**: Freemarker
- **marshalling**: Jackson (for JSON)
- **testing**: JUnit
- **utils**: Lombok

## How to run it
* run 'mvn clean install' inside the main project
* run 'mvn tomcat7:run' inside the spring-jaxrs-backend folder
* run 'mvn tomcat7:run' inside the spring-jaxrs-frontend folder
* go to http://localhost:8090/

## Call the API from the browser:

- regular call
http://localhost:xxxx/api/fortune-cookie/14

- exception handle
http://localhost:xxxx/api/fortune-cookie/12

- jsr-349 validation handle
http://localhost:xxxx/api/fortune-cookie/103
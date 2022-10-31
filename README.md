# Spring Boot Sample

This is a sample project to show the integration between Spring Data JPA and MS-SQL Server, as well as
show a simple approach on how to use the Spring Security with basic authentication.

### Preparation

Have MS-SQL Server 2019 installed and create a database named poc with the administrator
named ```sa``` and ```password``` manage`.

### Build the Application

Use the gradle bootJar build task to build a fat jar with all the dependencies.

### Run the application

Run the command ```java -jar ServerApp-1.0.jar```.
By default, the application runs on port ```8080```.

To change the port run the application with the command ```java -jar ServerApp-1.0.jar --server.port=```,
and put the port you want after the equal sing.

### User Administrator

After you run for the first time the tables needed for this application should be created.
Just run the UserAdministrator.sql file under /src/main/sql to insert the Administrator user for the
application.

### HTTP Requests

For every request set the authorization header with the username ```Administrator``` and the password
```manage```
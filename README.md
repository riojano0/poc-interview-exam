# REST Test from Interview

This exercise is from a consulting company

1) Provide application for the administration of the purchase of products. They should include:
- ABM - products.
- ABM - clients.
- Generate new purchase transactions.
- Status of purchase transactions.
- Handle of purchase transaction approval or cancellation.
 
2) The services must bring logs about if the operation was successful or not.
  
3) Document the services implemented.
 
4) Unit-test coverage major than 75%.
 
5) Note: If want to extend the design with security or spa, handle on different branch.

Run The application with: 

```mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=local"```
or
```Run from Intellij with the VM option -Dspring.profiles.active=local```

Check if the boilerplate work:

`curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"message":"hit foo/bar"}' localhost:8080/foo/bar `

Bonus that can be include on the same branch

1) Host the application in some services similar to Heroku, Cloudfoudry, APP Engine, etc. (Bring the Url).
2) ABM - Sellers.
3) Integration Test.
4) Move to MySQL and use H2(Or Docker container with MySQL) for tests.
5) Add SonarQube without critical flags.
6) Wrap the application on a Docker-image.
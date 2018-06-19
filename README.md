# SpringBootRefresher
A simple demo application if a quick refresher on Spring Boot is ever needed.

### Features 
1. There are a ton of comments and generic names for following along. 
2. It uses Spring Data JPA for the database, allowing for convenient querying without writing code. 
3. There is both a `@RestController` and `@Controller` so that one can easily see the difference between the two. 
4. Thymelead template engine is used. The HTML files in `/src/main/resources` all contain examples of Thymeleaf integration. 
5. Bootstrap CSS and minified CSS files have been added, though the dependencies could have also been added to the `pom.xml` file. 
6. There are examples of injecting property values from `application.properties` into variables in the controllers. Both `@Value` and `@Autowired` annotations were used. 

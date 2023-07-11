package mx.com.springlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringLabsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringLabsApplication.class, args);
    }
    
     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringLabsApplication.class);
    }

}
/*
****Configuracioon de creacioon
mx.com
springlabs
0.0.1
jar
SpringLabs
Haciendo un acervo tecnológico
mx.com.sprinnglabs
java
8

Spring Boot DevTools
Lombok
Spring Web
Thymeleaf
Spring Security
Spring Data JPA
MySQL Driver
2.7.12
SprinngLabs

****Creacioon de base de datos
CREATE SCHEMA `laboratorio_spring` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

****Tutorial Api Rest BD MySQL
https://www.youtube.com/watch?v=vTu2HQrXtyw&t=798s

****Protege tu API usando JWT y Spring Security (2022)
https://www.youtube.com/watch?v=_p-Odh3MZJc

****Spring REST Error Handling Example
https://mkyong.com/spring-boot/spring-rest-error-handling-example/
 */

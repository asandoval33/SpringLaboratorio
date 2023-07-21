/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jota117
 * // TODO JavaMelody se genera operacion para validacion si es que no tienen alguna operacion
 */
@RestController
public class HelloWorldController {
  
     @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
}

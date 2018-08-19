package com.julian21olarte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void postConstructor() {
        System.out.println("Hello world!");
    }

    // localhost:8080/routa/abcde/julian?edad=23
    @GetMapping(value = "/ruta/{id}/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity ruta(@PathVariable("id") String id, @PathVariable("nombre") String nombre, @RequestParam String edad) {
        Map<String, String> response = new HashMap<>();
        if(id.equals("abcde") && nombre != null && edad != null) {
            response.put("response", "Esta es la ruta");
            response.put("nombre", nombre);
            response.put("edad", edad);
            return new ResponseEntity(response, HttpStatus.OK);
        } else {
            response.put("response", "Error");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}

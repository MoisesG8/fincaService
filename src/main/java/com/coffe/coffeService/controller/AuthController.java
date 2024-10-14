package com.coffe.coffeService.controller;

import com.coffe.coffeService.dto.LoginDTO;
import com.coffe.coffeService.dto.LoginResponse;
import com.coffe.coffeService.dto.ProductorResponse;
import com.coffe.coffeService.service.ProductoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    ProductoreService productoreService;


    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            LoginResponse respuesta = productoreService.login(loginDTO.getEmail(), loginDTO.getPassword());
            if (respuesta != null) {
                return ResponseEntity.ok(respuesta);
            } else {
                return  ResponseEntity.ok(new LoginResponse());
            }
        } catch (Exception e) {
            LOGGER.error("ERROR ", e);
             return  ResponseEntity.ok(new LoginResponse());
        }
    }
}

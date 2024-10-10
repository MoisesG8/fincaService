package com.coffe.coffeService.controller;

import com.coffe.coffeService.dto.LoginDTO;
import com.coffe.coffeService.dto.LoginResponse;
import com.coffe.coffeService.dto.ProductorResponse;
import com.coffe.coffeService.service.ProductoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    ProductoreService productoreService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            LoginResponse respuesta = productoreService.login(loginDTO.getEmail(), loginDTO.getPassword());
            if (respuesta != null) {
                return ResponseEntity.ok(respuesta);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas.");
            }
        } catch (Exception e) {
            LOGGER.error("ERROR ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error durante el inicio de sesión.");
        }
    }
}

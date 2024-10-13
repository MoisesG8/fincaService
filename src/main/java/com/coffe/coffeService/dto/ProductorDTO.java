package com.coffe.coffeService.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ProductorDTO {
    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String password;
    private String ubicacion;
    private String contacto;
}

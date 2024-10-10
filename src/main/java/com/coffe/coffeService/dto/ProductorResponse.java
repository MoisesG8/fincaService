package com.coffe.coffeService.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductorResponse {

    private Long id;

    private String nombre;

    private String apellido;

    private String usuario;

    private String email;

    private String contacto;

    private String ubicacion;
}

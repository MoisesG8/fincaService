package com.coffe.coffeService.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FincaDTO {
    private String nombre;
    private String ubicacion;
    private BigDecimal tamanioHectareas;
    private Long productorId; // Para asociar la finca con el productor

}

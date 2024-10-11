package com.coffe.coffeService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CultivoDto {
    private Long finca_id;
    private String variedad;
    private LocalDate fecha;
    private String estado;
}

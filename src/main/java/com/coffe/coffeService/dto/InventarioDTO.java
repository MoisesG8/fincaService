package com.coffe.coffeService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InventarioDTO {

    private Long finca_id;
    private String producto;
    private int cantidad;
    private String unidad;
    private LocalDate fecha_registro;
}

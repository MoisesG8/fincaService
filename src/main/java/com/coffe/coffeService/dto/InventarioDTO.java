package com.coffe.coffeService.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class InventarioDTO {

    private Long finca_id;
    private String producto;
    private BigDecimal cantidad;
    private String unidad;
    private LocalDate fecha_registro;
}

package com.coffe.coffeService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeguimientoDTO {
    private Long planificacion_id;
    private LocalDate fecha;
    private String actividad_realizada;
    private String observaciones;
}

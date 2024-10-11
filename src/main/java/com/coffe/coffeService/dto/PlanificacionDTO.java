package com.coffe.coffeService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlanificacionDTO {
    private Long finca_id;
    private String actividad;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;
}

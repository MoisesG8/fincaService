package com.coffe.coffeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SeguimientoPlanificacionDTO {
    private String actividadRealizada;
    private LocalDate fecha;
    private String observaciones;
    private Long planificacionId;
}
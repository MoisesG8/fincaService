package com.coffe.coffeService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "seguimiento")
@AllArgsConstructor
@NoArgsConstructor
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seguimiento_id")
    private Long seguimientoId;

    @ManyToOne
    @JoinColumn(name = "planificacion_id", nullable = false)
    private Planificacion planificacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "actividad_realizada", columnDefinition = "TEXT")
    private String actividadRealizada;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;
}

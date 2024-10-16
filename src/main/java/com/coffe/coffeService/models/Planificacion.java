package com.coffe.coffeService.models;

import com.coffe.coffeService.dto.PlanificacionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "planificacion")
@AllArgsConstructor
@NoArgsConstructor
public class Planificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planificacion_id")
    private Long planificacionId;

    @ManyToOne
    @JoinColumn(name = "finca_id", nullable = false)
    private Finca finca;

    @Column(name = "actividad", length = 100)
    private String actividad;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "estado", length = 50)
    private String estado;

    @OneToMany(mappedBy = "planificacion", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientos;
}

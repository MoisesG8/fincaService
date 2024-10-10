package com.coffe.coffeService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "produccion")
@AllArgsConstructor
@NoArgsConstructor
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produccion_id")
    private Long produccionId;

    @ManyToOne
    @JoinColumn(name = "cultivo_id", nullable = false)
    private Cultivo cultivo;

    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "unidad", length = 20)
    private String unidad;

    @Column(name = "fecha_cosecha")
    private LocalDate fechaCosecha;
}
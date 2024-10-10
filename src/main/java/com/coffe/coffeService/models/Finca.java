package com.coffe.coffeService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "fincas")
@AllArgsConstructor
@NoArgsConstructor
public class Finca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finca_id")
    private Long fincaId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "tamanio_hectareas", precision = 10, scale = 2)
    private BigDecimal tamanioHectareas;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "productor_id", nullable = false)
    @JsonIgnore
    private Productor productor;
}

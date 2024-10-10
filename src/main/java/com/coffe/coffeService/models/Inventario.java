package com.coffe.coffeService.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "inventarios")
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventario_id")
    private Long inventarioId;

    @ManyToOne
    @JoinColumn(name = "finca_id", nullable = false)
    private Finca finca;

    @Column(name = "producto", nullable = false, length = 100)
    private String producto;

    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "unidad", length = 20)
    private String unidad;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;
}

package com.coffe.coffeService.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cultivos")
@AllArgsConstructor
@NoArgsConstructor
public class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cultivo_id")
    private Long cultivoId;

    @ManyToOne
    @JoinColumn(name = "finca_id", nullable = false)
    private Finca finca;

    @Column(name = "variedad", length = 50)
    private String variedad;

    @Column(name = "fecha_siembra")
    private LocalDate fechaSiembra;

    @Column(name = "estado", length = 50)
    private String estado;
}

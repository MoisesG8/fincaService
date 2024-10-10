package com.coffe.coffeService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "informes")
@AllArgsConstructor
@NoArgsConstructor
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "informe_id")
    private Long informeId;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "fecha_generacion")
    private LocalDate fechaGeneracion;

    @Column(name = "contenido", columnDefinition = "TEXT")
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "productor_id", nullable = false)
    private Productor productor;
}

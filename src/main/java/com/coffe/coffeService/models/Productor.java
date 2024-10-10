package com.coffe.coffeService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "productores")
@AllArgsConstructor
@NoArgsConstructor
public class Productor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productor_id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "usuario", nullable = false, length = 15)
    private String usuario;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "ubicación", columnDefinition = "TEXT")
    private String ubicacion;

    @Column(name = "contacto", nullable = false, length = 50)
    private String contacto;

    @Column(name = "fecha_registro", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate fechaRegistro;

    @Column(name = "actualizado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime actualizadoEn;

    @OneToMany(mappedBy = "productor")
    private List<Finca> fincas;
}

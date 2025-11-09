package com.gestion.coches.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coche")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private LocalDate fabrication_year;

    @Column(nullable = false)
    private String tipo_carroceria;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "motor_id")
    private Motor motor;
}

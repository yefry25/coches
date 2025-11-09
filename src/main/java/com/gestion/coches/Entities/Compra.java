package com.gestion.coches.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "compra")
public class Compra
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "coche_id")
    private Coche coche;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Double precio_final;
}

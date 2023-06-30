package com.finanzas.trabajoFinanzas.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="planPagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanPagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username",nullable = false,length = 50)
    private String username;
    @Column(name="capital",nullable = false,length = 50)
    private double capital;
    @Column(name="tasaInteres",nullable = false,length = 50)
    private double tasaInteres;
    @Column(name="prestamo",nullable = false,length = 50)
    private double prestamo;
    @Column(name="plazo",nullable = false,length = 50)
    private int plazo;
    @Column(name="periodoGracia",nullable = false,length = 50)
    private int periodoGracia;
    @Column(name="tipoPlazoGracia",nullable = false,length = 50)
    private String tipoPlazoGracia;
    @Column(name="moneda",nullable = false,length = 50)
    private int moneda;
    @Column(name="tipoTasaInteres",nullable = false,length = 50)
    private String tipoTasaInteres;
    @Column(name="van",nullable = false,length = 50)
    private double van;
    @Column(name="tir",nullable = false,length = 50)
    private double tir;
    @Column(name="totalPagado",nullable = false,length = 50)
    private double totalPagado;
    @OneToMany(mappedBy = "planPagos", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ResultadoPago> resultados;
}

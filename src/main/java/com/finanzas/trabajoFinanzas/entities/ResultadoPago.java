package com.finanzas.trabajoFinanzas.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resultadoPago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="mes",nullable = false,length = 50)
    private double mes;
    @Column(name="tipoPlazoGracia",nullable = false,length = 50)
    private String tipoPlazoGracia;
    @Column(name="saldoInicial",nullable = false,length = 50)
    private double saldoInicial;
    @Column(name="saldoDeuda",nullable = false,length = 50)
    private double saldoDeuda;
    @Column(name="intereses",nullable = false,length = 50)
    private double intereses;
    @Column(name="amortizacionCapital",nullable = false,length = 50)
    private double amortizacionCapital;
    @Column(name="cuotaCapital",nullable = false,length = 50)
    private double cuotaCapital;
    @Column(name="cuotaMensual",nullable = false,length = 50)
    private double cuotaMensual;
    @Column(name="tipoMoneda",nullable = false,length = 50)
    private String tipoMoneda;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_pagos_id")
    @JsonBackReference
    private PlanPagos planPagos;
}
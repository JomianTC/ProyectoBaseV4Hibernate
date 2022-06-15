/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author JomianTC
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Articulo")
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulo;

    @Column(name = "nombreArticulo", length = 50, nullable = false)
    private String nombreArticulo;

    @Column(name = "descripcionArticulo", length = 150, nullable = false)
    private String descripcionArticulo;

    @Column(name = "existencias", nullable = false)
    private int existencias;

    @Column(name = "stockMinimo", nullable = false)
    private int stockMinimo;

    @Column(name = "stockMaximo", nullable = false)
    private int stockMaximo;

    @Column(name = "precio", nullable = false)
    private double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}

package com.producto.ms_producto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idLibro;

    @Column(name = "nombre_producto")
    private String titulo;

    private String autor;
    @Column(name = "precio", columnDefinition = "DECIMAL(10,2)")
    private double precio;
    private Integer stock;
    private String isbn;
}
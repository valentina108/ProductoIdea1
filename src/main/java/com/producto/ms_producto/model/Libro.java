package com.producto.ms_producto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Libros")
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    private String titulo;

    private String autor;
    private double precio;
    private int stock;
    private String isbn;
}

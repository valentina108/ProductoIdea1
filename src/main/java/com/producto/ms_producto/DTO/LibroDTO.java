package com.producto.ms_producto.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LibroDTO {

    private Long idLibro;

    @NotBlank(message = "El titulo del libro es obligatorio.")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio.")
    private String autor;

    @NotNull(message = "El precio es obligatorio.")
    private double precio;

    @NotNull(message = "El Stock es obligatorio.")
    private int stock;

    @NotBlank(message = "El isbn es obligatorio.")
    private String isbn;
}

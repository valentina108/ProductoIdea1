package com.producto.ms_producto.controller;

import com.producto.ms_producto.DTO.LibroDTO;
import com.producto.ms_producto.model.Libro;
import com.producto.ms_producto.repository.LibroRepository;
import com.producto.ms_producto.services.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class LibroController {

    @Autowired
    private LibroService libroService;
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> listar(){
        return libroService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@Valid @RequestBody LibroDTO libroDTO){
        return ResponseEntity.ok(libroService.guardar(libroDTO));
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Libro> obtenerPorIsbn(@PathVariable String isbn){
        Libro libro = libroService.buscarPorIsbn(isbn);
        return ResponseEntity.ok(libro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(libroRepository.findById(id).orElseThrow());
    }
}

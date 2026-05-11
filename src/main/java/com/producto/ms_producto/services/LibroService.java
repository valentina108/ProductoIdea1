package com.producto.ms_producto.services;

import com.producto.ms_producto.DTO.LibroDTO;
import com.producto.ms_producto.exception.RecursoDuplicadoException;
import com.producto.ms_producto.model.Libro;
import com.producto.ms_producto.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarTodos(){
        return libroRepository.findAll();
    }

    public Libro guardar(LibroDTO dto) {

        if (libroRepository.findByIsbn(dto.getIsbn()).isPresent()) {
            throw new RecursoDuplicadoException("El libro con ISBN " + dto.getIsbn() + " ya existe.");
        }

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setPrecio(dto.getPrecio());
        libro.setStock(dto.getStock());
        libro.setIsbn(dto.getIsbn());

        return libroRepository.save(libro);
    }

    public Libro buscarPorIsbn(String isbn){
        return libroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RecursoDuplicadoException("No encontramos el libro con ISBN: " + isbn));
    }
}

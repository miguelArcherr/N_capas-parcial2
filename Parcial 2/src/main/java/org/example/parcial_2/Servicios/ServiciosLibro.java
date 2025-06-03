package org.example.parcial_2.Servicios;

import lombok.NoArgsConstructor;
import org.example.parcial_2.Entidades.Libro;
import org.example.parcial_2.Entidades.dto.CrearLibroDto;
import org.example.parcial_2.Repositorio.RepoLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
public class ServiciosLibro {

    @Autowired
    private RepoLibro repoLibro;


    public void crearLibro(CrearLibroDto libroData) {
        Libro libro = new Libro();
        libro.setTitulo(libroData.getTitulo());
        libro.setAutor(libroData.getAutor());
        libro.setIsbn(libroData.getIsbn());
        libro.setAnio(libroData.getAnio());
        libro.setLenguaje(libroData.getLenguaje());
        libro.setGenero(libroData.getGenero());
        libro.setPaginas(libroData.getPaginas());
        repoLibro.save(libro);
    }
    public List<Libro> verTodosLibros(){
        return repoLibro.findAll();
    }

    public void eliminarLibro(String id) {
        UUID libroId = UUID.fromString(id);
        Optional<Libro> libroOpcional = repoLibro.findById(libroId);
        if (libroOpcional.isEmpty()){
            throw new RuntimeException("Libro no encontrado");
        }
        repoLibro.delete(libroOpcional.get());
    }
}

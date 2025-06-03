package org.example.parcial_2.Repositorio;

import jakarta.transaction.Transactional;
import org.example.parcial_2.Entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Transactional
public interface RepoLibro extends JpaRepository<Libro, UUID> {



        // La consulta jpa
        public Libro findBytitulo(String titulo);

}

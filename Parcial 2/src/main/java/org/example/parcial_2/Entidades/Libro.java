package org.example.parcial_2.Entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String titulo;

    @Column
    private String autor;

    @Column
    private String isbn;

    @Column
    private Integer anio;

    @Column
    private String lenguaje;

    @Column
    private String genero;

    @Column
    private Integer paginas;

}

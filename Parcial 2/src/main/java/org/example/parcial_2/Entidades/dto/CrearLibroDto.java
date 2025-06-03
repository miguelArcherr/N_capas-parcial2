package org.example.parcial_2.Entidades.dto;
import jakarta.persistence.Column;
import lombok.Getter;

import java.util.UUID;


@Getter
public class CrearLibroDto {



    private String titulo;


    private String autor;


    private String isbn;


    private Integer anio;

    private String lenguaje;

    private String genero;

    private Integer paginas;
}
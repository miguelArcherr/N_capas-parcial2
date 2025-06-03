package org.example.parcial_2.Controladores;

import jakarta.validation.Valid;
import org.example.parcial_2.Entidades.Libro;
import org.example.parcial_2.Entidades.dto.CrearLibroDto;
import org.example.parcial_2.Servicios.ServiciosLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class ControladorLibro {


    @Autowired
    private ServiciosLibro serviciosLibro;

    @PostMapping("/crear")
    public ResponseEntity<Void> crearLibro(@RequestBody @Valid CrearLibroDto libroData){
        try {
            serviciosLibro.crearLibro(libroData);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Libro>> verTodosLirbos(@RequestParam("autor") String a){
        return ResponseEntity.ok(serviciosLibro.verTodosLibros());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable("id") String id){
        try {
            serviciosLibro.eliminarLibro(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}


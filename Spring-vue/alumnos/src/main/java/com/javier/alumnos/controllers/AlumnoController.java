package com.javier.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javier.alumnos.model.Alumno;
import com.javier.alumnos.repository.AlumnoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    //metodo get para traer to dos los alumnos de la base de datos
    @GetMapping("/traer-alumnos")
    public List<Alumno> TraerAlumno() {
        return alumnoRepository.findAll();
    }
    //metodo para insertar un alumno en la base de datos
    @PostMapping("/insertar-alumnos")
    public Alumno insertarAlumno(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
        
    
    }
    //Metodo para editar un alumno en la base de datos
    @PutMapping("/editar-alumnos/{id}")
    public ResponseEntity<Alumno> ActualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoRepository.findById(id).map(alumnoExistente -> {
            alumnoExistente.setNumeroControl(alumno.getNumeroControl());
            alumnoExistente.setNombre(alumno.getNombre());
            alumnoExistente.setApellidos(alumno.getApellidos());
            alumnoExistente.setTelefono(alumno.getTelefono());
            alumnoExistente.setEmail(alumno.getEmail());
            alumnoExistente.setCarrera(alumno.getCarrera());
            alumnoExistente.setImagenURL(alumno.getImagenURL());
            Alumno actualizado = alumnoRepository.save(alumnoExistente);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
}

package com.javier.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javier.alumnos.model.Alumno;
import com.javier.alumnos.repository.AlumnoRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping("/traer-alumnos")
    public List<Alumno> TraerAlumno() {
        return alumnoRepository.findAll();
    }

}

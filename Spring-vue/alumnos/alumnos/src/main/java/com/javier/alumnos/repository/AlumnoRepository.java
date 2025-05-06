package com.javier.alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javier.alumnos.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}

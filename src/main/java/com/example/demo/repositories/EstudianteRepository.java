package com.example.demo.repositories;

import com.example.demo.models.Estudiante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Estudiante e SET e.nombreCompleto = :nombre WHERE e.id = :id")
    void updateNombreEstudiante(@Param("nombre") String nombre, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Estudiante e SET e.carnet = :carnet WHERE e.id = :id")
    void updateCarnetEstudiante(@Param("carnet") String carnet, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Estudiante e SET e.carrera = :carrera WHERE e.id = :id")
    void updateCarreraEstudiante(@Param("carrera") String carrera, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Estudiante e SET e.correo = :correo WHERE e.id = :id")
    void updateCorreoEstudiante(@Param("correo") String correo, @Param("id") Integer id);
}

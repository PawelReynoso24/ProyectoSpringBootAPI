package com.example.demo.controllers;

import com.example.demo.models.Estudiante;
import com.example.demo.request.Request;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.EstudianteService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/apiSPEstudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    //Ruta para obtener todos los estudiantes
    //http://localhost:8080/apiSPEstudiante/ALLestudiantes
    @GetMapping("/ALLestudiantes")
    public ArrayList<Estudiante> obtenerTodoslosEstudiante() {
        return estudianteService.obtenerTodoslosEstudiante();
    }

    //Ruta para obtener un estudiante por id
    //http://localhost:8080/apiSPEstudiante/IDestudiantes/{id}
    @GetMapping("/IDestudiantes/{id}")
    public Optional<Estudiante> obtenerIDEstudiante(@PathVariable("id") Integer id) {
        return estudianteService.obtenerIDEstudiante(id);
    }

    //Ruta para guardar un estudiante (CREATE)
    //http://localhost:8080/apiSPEstudiante/guardarEstudiante
    @PostMapping("/guardarEstudiante")
    public ResponseEntity<ResponseDTO> guardarEstudiante(@RequestBody RequestDTO requestDTO) {
        return estudianteService.guardarEstudiante(requestDTO);
    }

    //Ruta para actualizar un estudiante (UPDATE)
    //http://localhost:8080/apiSPEstudiante/actualizarEstudiante
    @PutMapping("/actualizarEstudiante")
    public ResponseEntity<ResponseDTO> actualizarEstudiante(@RequestBody RequestDTO requestDTO) {
        return estudianteService.actualizarEstudiante(requestDTO);
    }

    //Ruta para eliminar un estudiante (DELETE)
    //http://localhost:8080/apiSPEstudiante/eliminarEstudiante/{id}
    @DeleteMapping("/eliminarEstudiante")
    public ResponseEntity<ResponseDTO> eliminarEstudiante(@RequestBody RequestDTO requestDTO) {
        return estudianteService.eliminarEstudiante(requestDTO);
    }
}

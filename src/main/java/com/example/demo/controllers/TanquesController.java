package com.example.demo.controllers;

import com.example.demo.models.Tanques;
import com.example.demo.request.Request;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.TanquesService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/apiSPTanques")
public class TanquesController {
    @Autowired
    TanquesService tanquesService;

    //Ruta para obtener todos los tanques
    //http://localhost:8080/apiSPTanques/ALLtanques
    @GetMapping("/ALLtanques")
    public ArrayList<Tanques> obtenerTodoslosTanques() {
        return tanquesService.obtenerTodoslosTanques();
    }

    //Ruta para obtener un tanque por id
    //http://localhost:8080/apiSPTanques/IDtanques/{id}
    @GetMapping("/IDtanques/{id}")
    public Optional<Tanques> obtenerIDTanque(@PathVariable("id") Integer id) {
        return tanquesService.obtenerIDTanque(id);
    }

    //Ruta para guardar un tanque (CREATE)
    //http://localhost:8080/apiSPTanques/guardarTanque
    @PostMapping("/guardarTanque")
    public ResponseEntity<ResponseDTO> guardarTanque(@RequestBody RequestDTO requestDTO) {
        return tanquesService.guardarTanque(requestDTO);
    }

    //Ruta para actualizar un tanque (UPDATE)
    //http://localhost:8080/apiSPTanques/actualizarTanque
    @PutMapping("/actualizarTanque")
    public ResponseEntity<ResponseDTO> actualizarTanque(@RequestBody RequestDTO requestDTO) {
        return tanquesService.actualizarTanque(requestDTO);
    }

    //Ruta para eliminar un tanque (DELETE)
    //http://localhost:8080/apiSPTanques/eliminarTanque/{id}
    @DeleteMapping("/eliminarTanque")
    public ResponseEntity<ResponseDTO> eliminarTanque(@RequestBody RequestDTO requestDTO) {
        return tanquesService.eliminarTanque(requestDTO);
    }

    //Ruta para obtener el nivel de un tanque
    //http://localhost:8080/apiSPTanques/obtenerNivelTanque/{id}
    @GetMapping("/obtenerNivelTanque/{id}")
    public Optional<Double> obtenerNivelTanque(@PathVariable("id") Integer id) {
        return tanquesService.obtenerNivelTanque(id);
    }
}

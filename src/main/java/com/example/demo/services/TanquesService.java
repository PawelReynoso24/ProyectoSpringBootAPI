package com.example.demo.services;

import com.example.demo.models.Tanques;
import com.example.demo.repositories.TanquesRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.EstudianteResponse;
import com.example.demo.response.ResponseDTO;
import com.example.demo.response.TanquesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class TanquesService {
    @Autowired
    TanquesRepository tanquesRepository;

    //Obtener todos los tanques

    public ArrayList<Tanques> obtenerTodoslosTanques() {
        return (ArrayList<Tanques>) tanquesRepository.findAll();
    }

    //Obtener un tanque por id
    public Optional<Tanques> obtenerIDTanque(Integer id) {
        if (tanquesRepository.existsById(id)) {
            return tanquesRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    //Guardar un tanque
    public ResponseEntity<ResponseDTO> guardarTanque(RequestDTO requestDTO) {
        //guardamos el objeto tanque en la base de datos
        Tanques tanque = tanquesRepository.save(requestDTO.getRequest().getTanques());

        //Llenar una respuesta al cliente
        TanquesResponse tanquesResponse = new TanquesResponse();
        tanquesResponse.setCapacidad(tanque.getCapacidad());
        tanquesResponse.setNivel_actual(tanque.getNivel_actual());
        tanquesResponse.setTipo_gasolina(tanque.getTipo_gasolina());
        tanquesResponse.setUbicacion(tanque.getUbicacion());
        tanquesResponse.setId_cliente(tanque.getId_cliente());
        tanquesResponse.setTipo_pago(tanque.getTipo_pago());
        tanquesResponse.setFecha(tanque.getFecha());
        tanquesResponse.setCreated_at(tanque.getCreated_at());
        tanquesResponse.setUpdated_at(tanque.getUpdated_at());

        //Dar una respuesta al cliente
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Tanque guardado exitosamente");
        responseDTO.setTanques(tanquesResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

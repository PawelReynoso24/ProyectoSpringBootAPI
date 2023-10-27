package com.example.demo.services;

import com.example.demo.models.Estudiante;
import com.example.demo.repositories.EstudianteRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.EstudianteResponse;
import com.example.demo.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    //Obtener todos los estudiantes
    public ArrayList<Estudiante> obtenerTodoslosEstudiante() {
        return (ArrayList<Estudiante>) estudianteRepository.findAll();
    }

    //Obtener un estudiante por id
    public Optional<Estudiante> obtenerIDEstudiante(Integer id) {
        if (estudianteRepository.existsById(id)) {
            return estudianteRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    //Guardar un estudiante
    public ResponseEntity<ResponseDTO> guardarEstudiante(RequestDTO requestDTO) {
        //guardamos el objeto estudiante en la base de datos
        Estudiante estudiante = estudianteRepository.save(requestDTO.getRequest().getEstudiante());

        //Llenar una respuesta al cliente
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        estudianteResponse.setNombreCompleto(estudiante.getNombreCompleto());
        estudianteResponse.setCarnet(estudiante.getCarnet());
        estudianteResponse.setCarrera(estudiante.getCarrera());
        estudianteResponse.setCorreo(estudiante.getCorreo());

        //Dar una respuesta al cliente
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Estudiante guardado exitosamente");
        responseDTO.setEstudiante(estudianteResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Actualizar un estudiante
    public ResponseEntity<ResponseDTO> actualizarEstudiante(RequestDTO requestDTO)
    {
        estudianteRepository.updateNombreEstudiante(requestDTO.getRequest().getEstudiante().getNombreCompleto(), requestDTO.getRequest().getEstudiante().getId());
        estudianteRepository.updateCarnetEstudiante(requestDTO.getRequest().getEstudiante().getCarnet(), requestDTO.getRequest().getEstudiante().getId());
        estudianteRepository.updateCarreraEstudiante(requestDTO.getRequest().getEstudiante().getCarrera(), requestDTO.getRequest().getEstudiante().getId());
        estudianteRepository.updateCorreoEstudiante(requestDTO.getRequest().getEstudiante().getCorreo(), requestDTO.getRequest().getEstudiante().getId());

        //Llenar una respuesta al cliente
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        estudianteResponse.setNombreCompleto(requestDTO.getRequest().getEstudiante().getNombreCompleto());
        estudianteResponse.setCarnet(requestDTO.getRequest().getEstudiante().getCarnet());
        estudianteResponse.setCarrera(requestDTO.getRequest().getEstudiante().getCarrera());
        estudianteResponse.setCorreo(requestDTO.getRequest().getEstudiante().getCorreo());

        //Dar una respuesta al cliente
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Estudiante actualizado exitosamente");
        responseDTO.setEstudiante(estudianteResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Eliminar un estudiante
    public ResponseEntity<ResponseDTO> eliminarEstudiante(RequestDTO requestDTO)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer id_estudiante = requestDTO.getRequest().getEstudiante().getId();
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        if (estudianteRepository.existsById(id_estudiante)) {
            estudianteRepository.deleteById(id_estudiante);

            //Llenar una respuesta al cliente+

            estudianteResponse.setId(requestDTO.getRequest().getEstudiante().getId());

            //Dar una respuesta al cliente

            responseDTO.setResponse("Estudiante eliminado exitosamente");
            responseDTO.setEstudiante(estudianteResponse);
        } else {
            //Llenar una respuesta al cliente
            estudianteResponse.setId(requestDTO.getRequest().getEstudiante().getId());

            //Dar una respuesta al cliente
            responseDTO.setResponse("Estudiante no encontrado");
            responseDTO.setEstudiante(estudianteResponse);
        }

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

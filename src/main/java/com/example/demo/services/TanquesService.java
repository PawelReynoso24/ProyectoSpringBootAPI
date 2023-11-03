package com.example.demo.services;

import com.example.demo.models.Tanques;
import com.example.demo.repositories.TanquesRepository;
import com.example.demo.request.RequestDTO;
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

    //API
    //Obtener todos el nivel del tanque
    public Optional<Double> obtenerNivelTanque(Integer id) {
        if (tanquesRepository.existsById(id)) {
            Optional<Tanques> tanqueOptional = tanquesRepository.findById(id);
            if (tanqueOptional.isPresent()) {
                return Optional.of(tanqueOptional.get().getNivel_actual());
            } else {
                return Optional.empty();
            }
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
        tanquesResponse.setPrecio_galon(tanque.getPrecio_galon());
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

    //Actualizar un tanque
public ResponseEntity<ResponseDTO> actualizarTanque(RequestDTO requestDTO) {
    tanquesRepository.updateCapacidadTanque(requestDTO.getRequest().getTanques().getCapacidad(), requestDTO.getRequest().getTanques().getId());
    tanquesRepository.updateNivelTanque(requestDTO.getRequest().getTanques().getNivel_actual(), requestDTO.getRequest().getTanques().getId());
    tanquesRepository.updateTipoGasolinaTanque(requestDTO.getRequest().getTanques().getTipo_gasolina(), requestDTO.getRequest().getTanques().getId());
    tanquesRepository.updateUbicacionTanque(requestDTO.getRequest().getTanques().getUbicacion(), requestDTO.getRequest().getTanques().getId());
    tanquesRepository.updatePrecioGalonTanque(requestDTO.getRequest().getTanques().getPrecio_galon(), requestDTO.getRequest().getTanques().getId());
    tanquesRepository.updateIdClienteTanque(requestDTO.getRequest().getTanques().getId_cliente(), requestDTO.getRequest().getTanques().getId());
    tanquesRepository.updateTipoPagoTanque(requestDTO.getRequest().getTanques().getTipo_pago(), requestDTO.getRequest().getTanques().getId());
    tanquesRepository.updateFechaTanque(requestDTO.getRequest().getTanques().getFecha(), requestDTO.getRequest().getTanques().getId());

    //Llenar una respuesta al cliente
    TanquesResponse tanquesResponse = new TanquesResponse();
    tanquesResponse.setCapacidad(requestDTO.getRequest().getTanques().getCapacidad());
    tanquesResponse.setNivel_actual(requestDTO.getRequest().getTanques().getNivel_actual());
    tanquesResponse.setTipo_gasolina(requestDTO.getRequest().getTanques().getTipo_gasolina());
    tanquesResponse.setUbicacion(requestDTO.getRequest().getTanques().getUbicacion());
    tanquesResponse.setPrecio_galon(requestDTO.getRequest().getTanques().getPrecio_galon());
    tanquesResponse.setId_cliente(requestDTO.getRequest().getTanques().getId_cliente());
    tanquesResponse.setTipo_pago(requestDTO.getRequest().getTanques().getTipo_pago());
    tanquesResponse.setFecha(requestDTO.getRequest().getTanques().getFecha());

    //Dar una respuesta al cliente
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setResponse("Tanque actualizado exitosamente");
    responseDTO.setTanques(tanquesResponse);

    return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Eliminar un tanque
    public ResponseEntity<ResponseDTO>eliminarTanque(RequestDTO requestDTO)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer id_tanque = requestDTO.getRequest().getTanques().getId();
        TanquesResponse tanquesResponse = new TanquesResponse();
        if (tanquesRepository.existsById(id_tanque)) {
            tanquesRepository.deleteById(id_tanque);

            //Llenar una respuesta al cliente+

            tanquesResponse.setId(requestDTO.getRequest().getTanques().getId());

            //Dar una respuesta al cliente

            responseDTO.setResponse("Tanque eliminado exitosamente");
            responseDTO.setTanques(tanquesResponse);
        } else {
            //Llenar una respuesta al cliente
            tanquesResponse.setId(requestDTO.getRequest().getTanques().getId());
            responseDTO.setResponse("El tanque no existe");
            responseDTO.setTanques(tanquesResponse);
        }

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //API
    //Actualizar el nivel del tanque
    public ResponseEntity<ResponseDTO> actualizarNivelTanque (RequestDTO requestDTO) {
        System.out.println(requestDTO.getRequest().getTanques().getNivel_actual());
        System.out.println(requestDTO.getRequest().getTanques().getId());
        tanquesRepository.updateNivelTanque(requestDTO.getRequest().getTanques().getNivel_actual(), requestDTO.getRequest().getTanques().getId());

        //Llenar una respuesta al cliente
        TanquesResponse tanquesResponse = new TanquesResponse();
        tanquesResponse.setNivel_actual(requestDTO.getRequest().getTanques().getNivel_actual());

        //Dar una respuesta al cliente
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Nivel del tanque actualizado exitosamente");
        responseDTO.setTanques(tanquesResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

package com.example.demo.services;

import com.example.demo.models.Persona;
import com.example.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public ArrayList<Persona> obtenerPersona() {
        return (ArrayList<Persona>) personaRepository.findAll();
    }

    public Optional<Persona> obtenerIDPersona(Integer id) {
        return personaRepository.findById(id);
    }
}

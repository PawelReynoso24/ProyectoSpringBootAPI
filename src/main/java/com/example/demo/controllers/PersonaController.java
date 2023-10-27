package com.example.demo.controllers;

import com.example.demo.models.Persona;
import com.example.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/apiSP")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/ALLpersonas")
    public  ArrayList<Persona> obtenerPersona() {
        return personaService.obtenerPersona();
    }

    @GetMapping("/IDpersonas/{id}")
    public Optional<Persona> obtenerIDPersona(@PathVariable("id") Integer id) {
        return this.personaService.obtenerIDPersona(id);
    }
}

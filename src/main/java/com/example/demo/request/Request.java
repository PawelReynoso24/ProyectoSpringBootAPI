package com.example.demo.request;

import com.example.demo.models.Estudiante;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.Tanques;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    @JsonProperty("user") //Para que el objeto se vea mas bonito en JSON
    private User user;
    @JsonProperty("role")
    private Role role;

    @JsonProperty("estudiantes")
    private Estudiante estudiante;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @JsonProperty("tanques")
    private Tanques tanques;

    public Tanques getTanques() {
        return tanques;
    }

    public void setTanques(Tanques tanques) {
        this.tanques = tanques;
    }
}

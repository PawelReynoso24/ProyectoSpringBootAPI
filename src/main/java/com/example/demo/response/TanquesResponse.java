package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL) //Para que no se muestren los valores nulos
@JsonIgnoreProperties(ignoreUnknown = true) //Para que no se muestren los valores que no estan definidos en el modelo
public class TanquesResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("capacidad")
    private String capacidad;
    @JsonProperty("nivel_actual")
    private Double nivel_actual;
    @JsonProperty("tipo_gasolina")
    private String tipo_gasolina;
    @JsonProperty("ubicacion")
    private String ubicacion;
    @JsonProperty("id_cliente")
    private Integer id_cliente;
    @JsonProperty("tipo_pago")
    private String tipo_pago;
    @JsonProperty("fecha")
    private Date fecha;
    @JsonProperty("created_at")
    private Timestamp created_at;
    @JsonProperty("updated_at")
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Double getNivel_actual() {
        return nivel_actual;
    }

    public void setNivel_actual(Double nivel_actual) {
        this.nivel_actual = nivel_actual;
    }

    public String getTipo_gasolina() {
        return tipo_gasolina;
    }

    public void setTipo_gasolina(String tipo_gasolina) {
        this.tipo_gasolina = tipo_gasolina;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}

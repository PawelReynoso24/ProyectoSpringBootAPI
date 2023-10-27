package com.example.demo.repositories;

import com.example.demo.models.Tanques;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TanquesRepository extends JpaRepository<Tanques, Integer>{
    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.capacidad = :capacidad WHERE t.id = :id")
    void updateCapacidadTanque(@Param("capacidad") String capacidad, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.nivel_actual = :nivel_actual WHERE t.id = :id")
    void updateNivelTanque(@Param("nivel_actual") Double nivel_actual, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.tipo_gasolina = :tipo_gasolina WHERE t.id = :id")
    void updateTipoGasolinaTanque(@Param("tipo_gasolina") String tipo_gasolina, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.ubicacion = :ubicacion WHERE t.id = :id")
    void updateUbicacionTanque(@Param("ubicacion") String ubicacion, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.precio_galon = :precio_galon WHERE t.id = :id")
    void updatePrecioGalonTanque(@Param("precio_galon") Double precio_galon, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.id_cliente = :id_cliente WHERE t.id = :id")
    void updateIdClienteTanque(@Param("id_cliente") Integer id_cliente, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.tipo_pago = :tipo_pago WHERE t.id = :id")
    void updateTipoPagoTanque(@Param("tipo_pago") String tipo_pago, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques t SET t.fecha = :fecha WHERE t.id = :id")
    void updateFechaTanque(@Param("fecha") Date fecha, @Param("id") Integer id);
}

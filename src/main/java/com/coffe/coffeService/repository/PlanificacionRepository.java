package com.coffe.coffeService.repository;

import com.coffe.coffeService.models.Planificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PlanificacionRepository extends JpaRepository<Planificacion, Long> {


    @Query("SELECT p.actividad FROM Planificacion p WHERE p.planificacionId = :planificacionId")
    String findActividadByPlanificacionId(@Param("planificacionId") Long planificacionId);

}

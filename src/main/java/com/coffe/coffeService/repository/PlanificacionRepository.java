package com.coffe.coffeService.repository;

import com.coffe.coffeService.models.Inventario;
import com.coffe.coffeService.models.Planificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanificacionRepository extends JpaRepository<Planificacion, Long> {

    @Query("SELECT c FROM Planificacion c JOIN c.finca f WHERE f.id = :fincaId")
    List<Planificacion> findPlanificacionWithFincas(Long fincaId);
}

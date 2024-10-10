package com.coffe.coffeService.repository;

import com.coffe.coffeService.models.Planificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanificacionRepository extends JpaRepository<Planificacion, Long> {
}

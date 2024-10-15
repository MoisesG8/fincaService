package com.coffe.coffeService.repository;

import com.coffe.coffeService.models.Cultivo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CultivoRepository extends CrudRepository<Cultivo, Long> {
    @Query("SELECT c FROM Cultivo c JOIN c.finca f WHERE f.id = :fincaId")
    List<Cultivo> findCultivosWithFincas(Long fincaId);
}

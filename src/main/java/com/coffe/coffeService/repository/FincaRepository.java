package com.coffe.coffeService.repository;
import com.coffe.coffeService.models.Productor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coffe.coffeService.models.Finca;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FincaRepository extends JpaRepository<Finca, Long> {

    List<Finca> findByProductor(Productor productor);

    @Query("SELECT f.nombre FROM Finca f WHERE f.fincaId = :fincaId")
    String findFincaByFincaId(Long fincaId);
}

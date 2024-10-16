package com.coffe.coffeService.repository;

import com.coffe.coffeService.models.Cultivo;
import com.coffe.coffeService.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    @Query("SELECT c FROM Inventario c JOIN c.finca f WHERE f.id = :fincaId")
    List<Inventario> findInventarioWithFincas(Long fincaId);
}

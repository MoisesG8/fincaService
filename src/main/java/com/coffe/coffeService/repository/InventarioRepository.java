package com.coffe.coffeService.repository;

import com.coffe.coffeService.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}

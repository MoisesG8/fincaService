package com.coffe.coffeService.repository;

import com.coffe.coffeService.dto.ProductoresFincas;
import com.coffe.coffeService.models.Productor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoresRepository extends JpaRepository<Productor, Long> {

    @Query("SELECT new com.coffe.coffeService.dto.ProductoresFincas(p.nombre, f.nombre, f.ubicacion) FROM Productor p JOIN p.fincas f")
    List<ProductoresFincas> findProductoresWithFincas();


    Optional<Productor> findByEmailAndPassword(String email, String password);
}

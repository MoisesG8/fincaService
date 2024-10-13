package com.coffe.coffeService.repository;
import com.coffe.coffeService.models.Productor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coffe.coffeService.models.Finca;

import java.util.List;

public interface FincaRepository extends JpaRepository<Finca, Long> {

    List<Finca> findByProductor(Productor productor);
}

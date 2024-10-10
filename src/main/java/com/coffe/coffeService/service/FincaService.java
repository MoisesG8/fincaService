package com.coffe.coffeService.service;

import com.coffe.coffeService.dto.FincaDTO;
import com.coffe.coffeService.models.Productor;
import com.coffe.coffeService.repository.ProductoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffe.coffeService.models.Finca;
import com.coffe.coffeService.repository.FincaRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FincaService {

    @Autowired
    private FincaRepository fincaRepository;

    @Autowired
    private ProductoresRepository productoresRepository;

    public Finca crearFinca(FincaDTO fincaDTO) {
        // Validar datos del DTO
        if (fincaDTO.getNombre() == null || fincaDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la finca no puede estar vacío");
        }

        // Buscar el productor por ID
        Productor productor = productoresRepository.findById(fincaDTO.getProductorId())
                .orElseThrow(() -> new RuntimeException("Productor no encontrado"));

        // Crear una nueva instancia de Finca
        Finca nuevaFinca = new Finca();
        nuevaFinca.setNombre(fincaDTO.getNombre());
        nuevaFinca.setUbicacion(fincaDTO.getUbicacion());
        nuevaFinca.setTamanioHectareas(fincaDTO.getTamanioHectareas());
        nuevaFinca.setFechaRegistro(LocalDate.now()); // Fecha actual como fecha de registro
        nuevaFinca.setProductor(productor);

        try {
            // Guardar la finca en la base de datos
            return fincaRepository.save(nuevaFinca);
        } catch (Exception e) {
            // Manejar el caso en que no se pueda crear la finca
            throw new RuntimeException("Error al crear la finca: " + e.getMessage());
        }
    }

    public Finca getFincaById(Long id) {
        if (fincaRepository.existsById(id)) {
            return fincaRepository.findById(id).get();
        } else {
            throw new RuntimeException("La finca no existe");
        }

    }

    public boolean eliminarFinca(Long id) {
        Optional<Finca> fincaOptional = fincaRepository.findById(id);
        if (fincaOptional.isPresent()) {
            fincaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
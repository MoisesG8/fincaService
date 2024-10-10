package com.coffe.coffeService.controller;

import com.coffe.coffeService.dto.FincaDTO;
import com.coffe.coffeService.dto.ProductoresFincas;
import com.coffe.coffeService.models.Finca;
import com.coffe.coffeService.models.Productor;
import com.coffe.coffeService.service.FincaService;
import com.coffe.coffeService.service.ProductoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RequestController {
    @Autowired
    private ProductoreService productoreService;

    @Autowired
    private FincaService fincaService;

    @GetMapping("/getAllProductores")
    public ResponseEntity<List<Productor>> getAllProductores(){
        List<Productor> productores = productoreService.getAllProductores();
        return ResponseEntity.ok(productores);
    }

    @PostMapping("/addProductor")
    public ResponseEntity<Productor> addProductor(@RequestBody Productor productor) {
        try {
            Productor newProductor = productoreService.saveProductor(productor);
            return new ResponseEntity<>(newProductor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductor(@PathVariable Long id) {
        productoreService.deleteProductor(id);
        return ResponseEntity.noContent().build(); // Responde con un 204 No Content si se elimina con éxito
    }

    @GetMapping("/getProductoresFincas")
    public ResponseEntity<List<ProductoresFincas>> getAllFincas(){
        List<ProductoresFincas> lista = productoreService.getAllProductoresFincas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/getProductor/{id}")
    public ResponseEntity<Productor> getProductorById(@PathVariable Long id){
        Productor productor = productoreService.getProductorById(id);
        return ResponseEntity.ok(productor);
    }

    @GetMapping("/getFinca/{id}")
    public ResponseEntity<Finca> getFincaById(@PathVariable Long id){
        return ResponseEntity.ok(fincaService.getFincaById(id));
    }

    @PostMapping("/addFinca")
    public ResponseEntity<String> agregarFinca(@RequestBody FincaDTO fincaDTO) {
        // Llamar al método del servicio para crear la finca
        Finca nuevaFinca = fincaService.crearFinca(fincaDTO);
        return ResponseEntity.ok("Finca '" + nuevaFinca.getNombre() + "' agregada exitosamente");
    }


    @DeleteMapping("/deleteFinca/{id}")
    public ResponseEntity<String> eliminarFinca(@PathVariable Long id) {
        try {
            boolean isDeleted = fincaService.eliminarFinca(id);
            if (isDeleted) {
                return ResponseEntity.ok("Finca eliminada exitosamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Finca no encontrada.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la finca.");
        }
    }

}

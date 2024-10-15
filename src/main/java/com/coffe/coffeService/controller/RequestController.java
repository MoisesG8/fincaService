package com.coffe.coffeService.controller;

import com.coffe.coffeService.dto.*;
import com.coffe.coffeService.models.*;
import com.coffe.coffeService.service.FincaService;
import com.coffe.coffeService.service.ProductoreService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/v1")
public class RequestController {

    @Autowired
    private ProductoreService productoreService;

    @Autowired
    private FincaService fincaService;

    @GetMapping(value = "/getAllProductores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Productor>> getAllProductores() {
        List<Productor> productores = productoreService.getAllProductores();
        return ResponseEntity.ok(productores);
    }

    @PostMapping(value = "/addProductor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Productor> addProductor(@RequestBody Productor productor) {
        try {
            Productor newProductor = productoreService.saveProductor(productor);
            return new ResponseEntity<>(newProductor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Productor(), HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductor(@PathVariable Long id) {
        productoreService.deleteProductor(id);
        return ResponseEntity.noContent().build(); // Responde con un 204 No Content si se elimina con éxito
    }

    @GetMapping("/getProductoresFincas")
    public ResponseEntity<List<ProductoresFincas>> getAllFincas() {
        List<ProductoresFincas> lista = productoreService.getAllProductoresFincas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/getProductor/{id}")
    public ResponseEntity<Productor> getProductorById(@PathVariable Long id) {
        Productor productor = productoreService.getProductorById(id);
        return ResponseEntity.ok(productor);
    }

    @GetMapping("/getFinca/{id}")
    public ResponseEntity<Finca> getFincaById(@PathVariable Long id) {
        return ResponseEntity.ok(fincaService.getFincaById(id));
    }

    @PostMapping("/addFinca")
    public ResponseEntity<Object> agregarFinca(@RequestBody FincaDTO fincaDTO) {
        // Llamar al método del servicio para crear la finca
        Map<String, String> response = new HashMap<>();
        try {
            Finca nuevaFinca = fincaService.crearFinca(fincaDTO);
            response.put("estado", "exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("estado", "error");
            return ResponseEntity.ok(response);
        }

    }

    @DeleteMapping("/deleteFinca/{id}")
    public ResponseEntity<Object> eliminarFinca(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            boolean isDeleted = fincaService.eliminarFinca(id);
            if (isDeleted) {
                response.put("estado", "exito");
                response.put("mensaje", "finca eliminada exitosamente");
                return ResponseEntity.ok(response);
            } else {
                response.put("estado", "error");
                response.put("mensaje", "finca no encontrada");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("estado", "error");
            response.put("mensaje", "error al eliminar la finca");
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/addPlanificacion")
    public ResponseEntity<?> agregarPlanificacion(@RequestBody PlanificacionDTO planificacionDTO) {
        Planificacion nuevaPlanificacion = fincaService.crearPlanificacion(planificacionDTO);
        return ResponseEntity.ok("Planificacion creada con exito: " + nuevaPlanificacion.getActividad());
    }

    @PostMapping("/addCultivo")
    public ResponseEntity<?> agregarCultivo(@RequestBody CultivoDto cultivoDto) {
        Cultivo cultivo = fincaService.crearCultivo(cultivoDto);
        return ResponseEntity.ok("Cultivo agregado con exito " + cultivo.getVariedad());
    }

    @PostMapping("/addInventario")
    public ResponseEntity<?> agregarInventario(@RequestBody InventarioDTO inventarioDTO) {
        Inventario inventario = fincaService.crearInventario(inventarioDTO);
        return ResponseEntity.ok("Inventario creado con exito");
    }

    @PostMapping("/addSeguimiento")
    public ResponseEntity<?> agregarSeguimiento(@RequestBody SeguimientoDTO seguimientoDTO) {
        Seguimiento seguimiento = fincaService.crearSeguimiento(seguimientoDTO);
        return ResponseEntity.ok("Seguimiento creado con exito");
    }

    @GetMapping("/getFincasDeProductor/{id}")
    public ResponseEntity<?> obtenerFincasDeProductor(@PathVariable Long id) {
        List<Finca> fincas = fincaService.getFincasProductor(id);
        return ResponseEntity.ok(fincas);
    }

    @PutMapping("/actualizarProductor/{id}")
    public ResponseEntity<Productor> actualizarProductor(
            @PathVariable Long id,
            @RequestBody ProductorDTO productorDTO) {

        Productor productorUpdate = productoreService.actualizarProductor(id, productorDTO);
        productorDTO.setPassword(null);
        return ResponseEntity.ok(productorUpdate);
    }

    @GetMapping(value = "/getAllFincas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Finca>> getAllFincasV2() {
        List<Finca> fincas = fincaService.getAllFincas();
        return ResponseEntity.ok(fincas);
    }

}

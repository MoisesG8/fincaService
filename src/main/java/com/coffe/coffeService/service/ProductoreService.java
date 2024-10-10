package com.coffe.coffeService.service;

import com.coffe.coffeService.dto.LoginResponse;
import com.coffe.coffeService.dto.ProductorResponse;
import com.coffe.coffeService.dto.ProductoresFincas;
import com.coffe.coffeService.models.Productor;
import com.coffe.coffeService.repository.ProductoresRepository;
import com.coffe.coffeService.utilerias.JwTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoreService {
    @Autowired
    private ProductoresRepository productoresRepository;

    @Autowired
    private JwTokenProvider jwtTokenProvider;


    public List<Productor> getAllProductores() {
        return productoresRepository.findAll();
    }

    public Productor saveProductor(Productor productor) {
        productor.setFechaRegistro(LocalDate.now()); // Establece la fecha de registro como la fecha actual
        productor.setActualizadoEn(LocalDateTime.now()); // Establece la fecha y hora actuales para actualizadoEn
        return productoresRepository.save(productor);
    }

    public void deleteProductor(Long id) {
        productoresRepository.deleteById(id);
    }

    public List<ProductoresFincas> getAllProductoresFincas() {
        List<ProductoresFincas> productoresFincas = new ArrayList<>();
        productoresFincas = productoresRepository.findProductoresWithFincas();
        return productoresFincas;
    }

    public Productor getProductorById(Long id) {
        return productoresRepository.findById(id).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
    }

    public LoginResponse login(String email, String password) {
        LoginResponse loginResponse = new LoginResponse();
        Optional<Productor> usuario = productoresRepository.findByEmail(email);
        if (usuario.isPresent()) {
            Productor productor = usuario.get();
            if (productor.getPassword().equals(password)) {
                String token = jwtTokenProvider.generateToken(email);
                ProductorResponse response = new ProductorResponse(productor.getId(), productor.getNombre(), productor.getApellido(), productor.getUsuario(), productor.getEmail(), productor.getContacto(), productor.getUbicacion());
                loginResponse.setToken(token);
                loginResponse.setProductorResponse(response);
            }
        }else{
            loginResponse = null;
        }
        return loginResponse;
    }

}

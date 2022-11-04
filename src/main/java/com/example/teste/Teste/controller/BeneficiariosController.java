package com.example.teste.Teste.controller;

import com.example.teste.Teste.DTO.BeneficiariosDTO;
import com.example.teste.Teste.database.BeneficiariosDB;
import com.example.teste.Teste.entity.Beneficiarios;
import com.example.teste.Teste.services.BeneficiariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiariosController {

    @Autowired
    private BeneficiariosService service;

    @GetMapping
    public ResponseEntity<List<BeneficiariosDB>> listAll() {
        List<BeneficiariosDB> listBeneficiarios = service.listAll();
        return ResponseEntity.ok().body(listBeneficiarios);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<BeneficiariosDTO> findById(@PathVariable Long id) {
        BeneficiariosDTO beneficiariosDTO = service.findById(id);
        return ResponseEntity.ok().body(beneficiariosDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Beneficiarios> update(@PathVariable Long id, @Valid @RequestBody Beneficiarios beneficiarios) {
        var beneficiariosService = service.update(id);
        return ResponseEntity.ok().body(beneficiariosService);
    }
}

package com.example.teste.Teste.controller;

import com.example.teste.Teste.database.PaisesDB;
import com.example.teste.Teste.entity.EnvelopDataJson;
import com.example.teste.Teste.entity.Paises;
import com.example.teste.Teste.services.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping
public class PaisesController {


    @Autowired
    private PaisesService paisesService;

    @GetMapping
    public ResponseEntity<List<PaisesDB>> listAll() {
        List<PaisesDB> listPaises = paisesService.listAll();
        return ResponseEntity.ok().body(listPaises);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<com.example.teste.Teste.DTO.PaisesDTO> findByName(@PathVariable String name) {
        com.example.teste.Teste.DTO.PaisesDTO paisesDTO = paisesService.findByName(name);
        return  ResponseEntity.ok().body(paisesDTO);
    }

    @GetMapping(value = "/nome")
    public ResponseEntity<com.example.teste.Teste.DTO.PaisesDTO> findByID(@PathVariable Integer id) {
        com.example.teste.Teste.DTO.PaisesDTO paisesDTO = paisesService.findById(id);
        return ResponseEntity.ok().body(paisesDTO);
    }
    @GetMapping(value = "/{codigo}")
    public ResponseEntity<com.example.teste.Teste.DTO.PaisesDTO> findByCodigo(@PathVariable Integer codigo) {
        com.example.teste.Teste.DTO.PaisesDTO paisesDTO = paisesService.findByCodigo(codigo);
        return  ResponseEntity.ok().body(paisesDTO);
    }

    @PostMapping
    public EnvelopDataJson<com.example.teste.Teste.DTO.PaisesDTO> insert(@Valid @RequestBody Paises paises) throws Exception {
        var responseFromDTO = paisesService.insert(paises);
        return new EnvelopDataJson<com.example.teste.Teste.DTO.PaisesDTO>(responseFromDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        paisesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id")
    public ResponseEntity<Paises> update(@PathVariable Integer id, @Valid @RequestBody Paises paises) {
        var service = paisesService.update(id, paises);
        return ResponseEntity.ok().body(service);
    }

}

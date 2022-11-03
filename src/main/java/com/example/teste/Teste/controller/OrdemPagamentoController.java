package com.example.teste.Teste.controller;

import com.example.teste.Teste.DTO.OrdemDTO;
import com.example.teste.Teste.database.OrdemPagamentoDB;
import com.example.teste.Teste.entity.EnvelopDataJson;
import com.example.teste.Teste.entity.OrdemPagamento;
import com.example.teste.Teste.services.OrdemPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/beneficiarios")
public class OrdemPagamentoController {

    @Autowired
    private OrdemPagamentoService service;

    @GetMapping
    public ResponseEntity<List<OrdemPagamentoDB>> listAll () {
        List<OrdemPagamentoDB> listPagamento = service.listAll();
        return ResponseEntity.ok().body(listPagamento);
    }

    @GetMapping(value = "/beneficiarios/{id}")
    public ResponseEntity<OrdemDTO> findById(@PathVariable Long id) {
        OrdemDTO ordemDTO = service.findById(id);
        return ResponseEntity.ok().body(ordemDTO);
    }

    //Verificar
    @PostMapping
    public EnvelopDataJson<OrdemDTO> insert(@Valid @RequestBody OrdemPagamento ordemPagto) throws Exception {
        var response = service.insert(ordemPagto);
        return new EnvelopDataJson<>(response);
    }
    @DeleteMapping(value = "/beneficiarios/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/beneficiarios/{id}")
    public ResponseEntity<OrdemPagamento> update(@PathVariable Long id, @Valid @RequestBody OrdemPagamento ordemPagamento) {
        var ordemPagto = service.update(id, ordemPagamento);
        return ResponseEntity.ok().body(ordemPagto);
    }

}

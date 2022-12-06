package com.example.teste.Teste.services.interfaces;

import com.example.teste.Teste.DTO.OrdemDTO;
import com.example.teste.Teste.database.OrdemPagamentoDB;
import com.example.teste.Teste.entity.OrdemPagamento;

import java.util.List;

public interface InterfaceOrdemPagamentoService {

    List<OrdemPagamentoDB> listAll();

    OrdemDTO findById(Long id);

    OrdemDTO insert(OrdemPagamento ordemPagamento) throws  Exception;

    void delete(Long id);

    OrdemPagamento update(Long id, OrdemPagamento ordemPagamento);
}

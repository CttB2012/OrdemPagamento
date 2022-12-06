package com.example.teste.Teste.services;


import com.example.teste.Teste.DTO.OrdemDTO;
import com.example.teste.Teste.database.OrdemPagamentoDB;
import com.example.teste.Teste.entity.OrdemPagamento;
import com.example.teste.Teste.exceptions.ExceptionApiOrdem;
import com.example.teste.Teste.repositories.OrdemPagamentoRepository;

import com.example.teste.Teste.services.interfaces.InterfaceOrdemPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrdemPagamentoService implements InterfaceOrdemPagamentoService {

    @Autowired
    private OrdemPagamentoRepository repository;


    @Override
    public List<OrdemPagamentoDB> listAll() {
        List<OrdemPagamentoDB> listaPagamentos = repository.findAll();
        return listaPagamentos;
    }

    @Override
    public OrdemDTO findById(Long id) {
        try {
            var ordem = repository.findById(id).get();
            OrdemDTO ordemDTO = new OrdemDTO();
            ordemDTO.setIdDocumentoBeneficiario(ordem.getIdDocumentoBeneficiario());
            ordemDTO.setCodigoMoeda(ordem.getCodigoMoeda());
            ordemDTO.setSimboloMoeda(ordem.getSimboloMoeda());
            ordemDTO.setValorMoedaEstrangeira(ordem.getValorMoedaEstrangeira());
            ordemDTO.setNomeBeneficiario(ordem.getNomeBeneficiario());
            ordemDTO.setNumeroOrdemPagamento(ordem.getNumeroOrdemPagamento());
            return ordemDTO;
        }catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-02", e.getMessage());
        }
    }

    @Override
    public OrdemDTO insert(OrdemPagamento ordemPagamento) throws  Exception {

        try {
            var ordem = mapToDb(ordemPagamento);
            var ordemDB = repository.save(ordem);

            return mapToDTO(ordemDB);

        }catch (Exception e){
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }
    }
    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-02", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-03", e.getMessage());
        }

    }
    @Override
    public OrdemPagamento update(Long id, OrdemPagamento ordemPagamento) {
        try {
            OrdemPagamentoDB ordemDataBase = repository.findById(id).get();

            updateData(ordemPagamento, ordemDataBase);

            repository.save(ordemDataBase);
            return ordemPagamento;
        }catch (NoSuchElementException e) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-02", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }
    }

    private void updateData(OrdemPagamento ordemPagamento, OrdemPagamentoDB ordemDataBase) {
        ordemDataBase.setCodigoMoeda(ordemPagamento.getCodigoMoeda());
        ordemDataBase.setSimboloMoeda(ordemPagamento.getSimboloMoeda());
        ordemDataBase.setValorMoedaEstrangeira(ordemPagamento.getValorMoedaEstrangeira());
        ordemDataBase.setNomeBeneficiario(ordemPagamento.getNomeBeneficiario());
        ordemDataBase.setNumeroOrdemPagamento(ordemPagamento.getNumeroOrdemPagamento());
    }

    public OrdemPagamentoDB mapToDb(OrdemPagamento ordemPagamento) {
        OrdemPagamentoDB ordemDB = new OrdemPagamentoDB();
        ordemDB.setNumeroOrdemPagamento(ordemPagamento.getNumeroOrdemPagamento());
        ordemDB.setCodigoMoeda(ordemPagamento.getCodigoMoeda());
        ordemDB.setSimboloMoeda(ordemPagamento.getSimboloMoeda());
        ordemDB.setValorMoedaEstrangeira(ordemPagamento.getValorMoedaEstrangeira());
        ordemDB.setNomeBeneficiario(ordemPagamento.getNomeBeneficiario());
        return ordemDB;
    }

    public OrdemDTO mapToDTO (OrdemPagamentoDB ordemPagamentoDB) {
        OrdemDTO ordemDTO = new OrdemDTO();
        ordemDTO.setIdDocumentoBeneficiario(ordemPagamentoDB.getIdDocumentoBeneficiario());
        ordemDTO.setNumeroOrdemPagamento(ordemPagamentoDB.getNumeroOrdemPagamento());
        ordemDTO.setCodigoMoeda(ordemPagamentoDB.getCodigoMoeda());
        ordemDTO.setSimboloMoeda(ordemPagamentoDB.getSimboloMoeda());
        ordemDTO.setValorMoedaEstrangeira(ordemPagamentoDB.getValorMoedaEstrangeira());
        ordemDTO.setNomeBeneficiario(ordemPagamentoDB.getNomeBeneficiario());
        return ordemDTO;
    }
}
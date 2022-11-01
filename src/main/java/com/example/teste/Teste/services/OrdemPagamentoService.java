package com.example.teste.Teste.services;


import com.example.teste.Teste.DTO.OrdemDTO;
import com.example.teste.Teste.database.OrdemPagamentoDB;
import com.example.teste.Teste.entity.OrdemPagamento;
import com.example.teste.Teste.repositories.OrdemPagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;




@Service
public class OrdemPagamentoService {

    @Autowired
    private OrdemPagamentoRepository repository;


    public List<OrdemPagamentoDB> listAll() {
        List<OrdemPagamentoDB> listaPagamentos = repository.findAll();
        return listaPagamentos;
    }

    public OrdemDTO findById(Long id) {

        var ordem = repository.findById(id).get();
        OrdemDTO ordemDTO = new OrdemDTO();
        ordemDTO.setIdDocumentoBeneficiario(ordem.getIdDocumentoBeneficiario());
        ordemDTO.setCodigoMoeda(ordem.getCodigoMoeda());
        ordemDTO.setSimboloMoeda(ordem.getSimboloMoeda());
        ordemDTO.setValorMoedaEstrangeira(ordem.getValorMoedaEstrangeira());
        ordemDTO.setNomeBeneficiario(ordem.getNomeBeneficiario());
        ordemDTO.setNumeroOrdemPagamento(ordem.getNumeroOrdemPagamento());
        return ordemDTO;
    }

    public OrdemDTO insert(OrdemPagamento ordemPagamento) throws  Exception {

        try {
            Optional<OrdemPagamentoDB> ordemPagamentoDatabase = repository.findById(ordemPagamento.getIdDocumentoBeneficiario());
            if (ordemPagamentoDatabase.isPresent()) {
                throw new Exception("Beneficiario já registrado");
            }
            var ordem = mapToDb(ordemPagamento, ordemPagamentoDatabase.get());
            var ordemDB = repository.save(ordem);

            return mapToDTO(ordemDB);


        }catch (Exception e) {
            throw e;
        }
    }
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw e;
        }

    }
    public OrdemPagamento update(Long id, OrdemPagamento ordemPagamento) {
        try {
            OrdemPagamentoDB ordemDataBase = repository.findById(id).get();
            updateData(ordemPagamento, ordemDataBase);
            ordemDataBase.setCodigoMoeda(ordemPagamento.getCodigoMoeda());
            ordemDataBase.setSimboloMoeda(ordemPagamento.getSimboloMoeda());
            ordemDataBase.setValorMoedaEstrangeira(ordemPagamento.getValorMoedaEstrangeira());
            ordemDataBase.setNomeBeneficiario(ordemPagamento.getNomeBeneficiario());
            return ordemPagamento;
        }catch (NoSuchElementException e) {
            throw e;
        }
    }

    //Perguntar sobre redundancia
    private void updateData(OrdemPagamento ordemPagamento, OrdemPagamentoDB ordemDataBase) {
        ordemDataBase.setCodigoMoeda(ordemPagamento.getCodigoMoeda());
        ordemDataBase.setSimboloMoeda(ordemPagamento.getSimboloMoeda());
        ordemDataBase.setValorMoedaEstrangeira(ordemPagamento.getValorMoedaEstrangeira());
        ordemDataBase.setNomeBeneficiario(ordemPagamento.getNomeBeneficiario());
    }

    public OrdemPagamentoDB mapToDb(OrdemPagamento ordemPagamento, OrdemPagamentoDB ordemPagamentoDB) {
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
        ordemDTO.setNumeroOrdemPagamento(ordemPagamentoDB.getNumeroOrdemPagamento());
        ordemDTO.setCodigoMoeda(ordemPagamentoDB.getCodigoMoeda());
        ordemDTO.setSimboloMoeda(ordemPagamentoDB.getSimboloMoeda());
        ordemDTO.setValorMoedaEstrangeira(ordemPagamentoDB.getValorMoedaEstrangeira());
        ordemDTO.setNomeBeneficiario(ordemPagamentoDB.getNomeBeneficiario());
        return ordemDTO;
    }
}
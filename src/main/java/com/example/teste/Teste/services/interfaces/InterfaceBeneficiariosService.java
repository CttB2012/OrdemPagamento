package com.example.teste.Teste.services.interfaces;

import com.example.teste.Teste.DTO.BeneficiariosDTO;
import com.example.teste.Teste.database.BeneficiariosDB;
import com.example.teste.Teste.entity.Beneficiarios;

import java.util.List;

public interface InterfaceBeneficiariosService {

    List<BeneficiariosDB> listAll();

    BeneficiariosDTO findById(Long id);

    BeneficiariosDTO insert(Beneficiarios beneficiarios) throws Exception;

    void delete(Long id);

    Beneficiarios update(Long id, Beneficiarios beneficiarios);

}

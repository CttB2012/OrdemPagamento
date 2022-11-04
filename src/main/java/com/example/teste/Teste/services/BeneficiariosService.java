package com.example.teste.Teste.services;


import com.example.teste.Teste.DTO.BeneficiariosDTO;
import com.example.teste.Teste.database.BeneficiariosDB;
import com.example.teste.Teste.entity.Beneficiarios;
import com.example.teste.Teste.exceptions.ExceptionApiOrdem;
import com.example.teste.Teste.repositories.BeneficiariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiariosService {

    @Autowired
    private BeneficiariosRepository repository;

    public List<BeneficiariosDB> listAll() {
        List<BeneficiariosDB> listaBeneficiarios = repository.findAll();
        return listaBeneficiarios;
    }
    public BeneficiariosDTO findById(Long id) {
        try {
            var beneficiarios = repository.findById(id).get();

            BeneficiariosDTO beneficiariosDTO = new BeneficiariosDTO();
            beneficiariosDTO.setIdDocumentoBeneficiario(beneficiarios.getIdDocumentoBeneficiario());
            beneficiariosDTO.setIdBeneficiario(beneficiarios.getIdBeneficiario());
            beneficiariosDTO.setNomeBeneficiario(beneficiarios.getNomeBeneficiario());
            return beneficiariosDTO;
        }catch (Exception e ) {
            throw e;
        }
    }
    public BeneficiariosDTO insert(Beneficiarios beneficiarios) throws Exception {

        try {
            var beneficiarios1 = mapToDB(beneficiarios);
            var benficiariosDB = repository.save(beneficiarios1);

            return mapToDTO(benficiariosDB);
        }catch (ExceptionApiOrdem e) {
            throw e;
        }catch (Exception e) {
            throw e;
        }

    }
    public BeneficiariosDB mapToDB(Beneficiarios beneficiarios) {
        BeneficiariosDB beneficiariosDB = new BeneficiariosDB();
        beneficiariosDB.setIdBeneficiario(beneficiarios.getIdBeneficiario());
        beneficiariosDB.setNomeBeneficiario(beneficiarios.getNomeBeneficiario());
        beneficiariosDB.setIdDocumentoBeneficiario(beneficiarios.getIdDocumentoBeneficiario());
        return beneficiariosDB;
    }
    public BeneficiariosDTO mapToDTO (BeneficiariosDB beneficiariosDB) {
        BeneficiariosDTO beneficiariosDTO = new BeneficiariosDTO();
        beneficiariosDTO.setIdBeneficiario(beneficiariosDB.getIdBeneficiario());
        beneficiariosDTO.setIdDocumentoBeneficiario(beneficiariosDB.getIdDocumentoBeneficiario());
        beneficiariosDTO.setNomeBeneficiario(beneficiariosDB.getNomeBeneficiario());
        return beneficiariosDTO;
    }
}

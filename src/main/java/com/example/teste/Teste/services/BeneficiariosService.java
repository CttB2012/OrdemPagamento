package com.example.teste.Teste.services;


import com.example.teste.Teste.DTO.BeneficiariosDTO;
import com.example.teste.Teste.database.BeneficiariosDB;
import com.example.teste.Teste.entity.Beneficiarios;
import com.example.teste.Teste.exceptions.ExceptionApiOrdem;
import com.example.teste.Teste.repositories.BeneficiariosRepository;
import com.example.teste.Teste.services.utils.NumeroDocumentoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

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
        }catch ( NoSuchElementException e ) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-04", e.getMessage());
        }catch (Exception e){
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }
    }
    public BeneficiariosDTO insert(Beneficiarios beneficiarios) throws Exception {

        try {

            var cpfValido = NumeroDocumentoUtils.validarCPF(beneficiarios.getIdDocumentoBeneficiario());
            if (cpfValido == false) {
                throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-05" );
            }

            var beneficiarios1 = mapToDB(beneficiarios);
            var beneficiariosDB = repository.save(beneficiarios1);

            return mapToDTO(beneficiariosDB);
        } catch (ExceptionApiOrdem e) {
            throw  e;
        } catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }
    }

    public BeneficiariosDB mapToDB(Beneficiarios beneficiarios) {
        BeneficiariosDB beneficiariosDB = new BeneficiariosDB();
        beneficiariosDB.setIdBeneficiario(beneficiarios.getIdBeneficiario());
        beneficiariosDB.setNomeBeneficiario(beneficiarios.getNomeBeneficiario());
        beneficiariosDB.setIdDocumentoBeneficiario(beneficiarios.getIdDocumentoBeneficiario());
        return beneficiariosDB;
    }
    public BeneficiariosDTO mapToDTO(BeneficiariosDB beneficiariosDB) {
        BeneficiariosDTO beneficiariosDTO = new BeneficiariosDTO();
        beneficiariosDTO.setIdBeneficiario(beneficiariosDB.getIdBeneficiario());
        beneficiariosDTO.setIdDocumentoBeneficiario(beneficiariosDB.getIdDocumentoBeneficiario());
        beneficiariosDTO.setNomeBeneficiario(beneficiariosDB.getNomeBeneficiario());
        return beneficiariosDTO;
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw e;
        }catch (Exception e) {
            throw e;
        }
    }
    public Beneficiarios update(Long id, Beneficiarios beneficiarios) {
        try {
            BeneficiariosDB beneficiariosDB = repository.findById(id).get();
            updateData(beneficiarios, beneficiariosDB);
            repository.save(beneficiariosDB);
            return beneficiarios;
        }catch (NoSuchElementException e) {
            throw e;
        }catch (Exception e){
            throw e;
        }
    }
    private void updateData(Beneficiarios beneficiarios, BeneficiariosDB beneficiariosDB) {
        beneficiariosDB.setIdBeneficiario(beneficiarios.getIdBeneficiario());
        beneficiariosDB.setIdDocumentoBeneficiario(beneficiarios.getIdDocumentoBeneficiario());
        beneficiariosDB.setNomeBeneficiario(beneficiarios.getNomeBeneficiario());
    }

}

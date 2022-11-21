package com.example.teste.Teste.services;



import com.example.teste.Teste.DTO.PaisesDTO;
import com.example.teste.Teste.database.PaisesDB;
import com.example.teste.Teste.repositories.PaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/codigos")
public class PaisesService {


    @Autowired
    private PaisesRepository paisesRepository;

    public List<PaisesDB> listAll() {
        List<PaisesDB> listaDePaises = paisesRepository.findAll();
        return  listaDePaises;
    }

    public PaisesDTO findById(Integer id) {

        var paises = paisesRepository.findById(id).get();

        PaisesDTO paisesDTO = new PaisesDTO();
        paisesDTO.setIdPais(paises.getIdPais());
        paisesDTO.setNomePais(paises.getNomePais());
        paisesDTO.setCodigoPais(paises.getCodigoPais());
        return paisesDTO;

    }

}

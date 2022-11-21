package com.example.teste.Teste.services;



import com.example.teste.Teste.DTO.PaisesDTO;
import com.example.teste.Teste.database.PaisesDB;
import com.example.teste.Teste.entity.Paises;
import com.example.teste.Teste.repositories.PaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
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

    public com.example.teste.Teste.DTO.PaisesDTO findById(Integer id) {

        var paisesDB = paisesRepository.findById(id).get();

        com.example.teste.Teste.DTO.PaisesDTO paisesDTO = new com.example.teste.Teste.DTO.PaisesDTO();
        paisesDTO.setIdPais(paisesDB.getIdPais());
        paisesDTO.setNomePais(paisesDB.getNomePais());
        paisesDTO.setCodigoPais(paisesDB.getCodigoPais());
        return paisesDTO;

    }

    public com.example.teste.Teste.DTO.PaisesDTO findByName(String nome) {

        var paisesDB = paisesRepository.findByName(nome).get();

        com.example.teste.Teste.DTO.PaisesDTO paisesDTO = new com.example.teste.Teste.DTO.PaisesDTO();
        paisesDTO.setIdPais(paisesDB.getIdPais());
        paisesDTO.setNomePais(paisesDB.getNomePais());
        paisesDTO.setCodigoPais(paisesDB.getCodigoPais());
        return paisesDTO;

    }
    public com.example.teste.Teste.DTO.PaisesDTO findByCodigo(Integer codigo) {

        var paisesDB = paisesRepository.findByCodigo(codigo).get();

        com.example.teste.Teste.DTO.PaisesDTO paisesDTO = new com.example.teste.Teste.DTO.PaisesDTO();
        paisesDTO.setIdPais(paisesDB.getIdPais());
        paisesDTO.setNomePais(paisesDB.getNomePais());
        paisesDTO.setCodigoPais(paisesDB.getCodigoPais());
        return paisesDTO;
    }

    public PaisesDTO insert(Paises paises) throws  Exception{

        var paisesMapper = mapToDB(paises);
        var paisesDB = paisesRepository.save(paisesMapper);

        return mapToDTO(paisesDB);
    }

    public PaisesDB mapToDB(Paises paises) {

        PaisesDB paisesDB = new PaisesDB();
        paisesDB.setIdPais(paises.getIdPais());
        paisesDB.setNomePais(paises.getNomePais());
        paisesDB.setCodigoPais(paises.getCodigoPais());
        return paisesDB;
    }

    public PaisesDTO mapToDTO(PaisesDB paisesDB) {

        PaisesDTO paisesDTO = new PaisesDTO();

        paisesDTO.setIdPais(paisesDB.getIdPais());
        paisesDTO.setNomePais(paisesDB.getNomePais());
        paisesDTO.setCodigoPais(paisesDB.getCodigoPais());
        return paisesDTO;
    }
    public void delete(Integer id) {

        paisesRepository.deleteById(id);
    }
}




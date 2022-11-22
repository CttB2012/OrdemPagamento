package com.example.teste.Teste.services;



import com.example.teste.Teste.DTO.PaisesDTO;
import com.example.teste.Teste.database.PaisesDB;
import com.example.teste.Teste.entity.Paises;
import com.example.teste.Teste.exceptions.ExceptionApiOrdem;
import com.example.teste.Teste.repositories.PaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaisesService {


    @Autowired
    private PaisesRepository paisesRepository;

    public List<PaisesDB> listAll() {
        List<PaisesDB> listaDePaises = paisesRepository.findAll();
        return  listaDePaises;
    }

    public PaisesDTO findById(Integer id) {

        try{
            var paisesDB = paisesRepository.findById(id).get();

            PaisesDTO paisesDTO = new PaisesDTO();
            paisesDTO.setIdPais(paisesDB.getIdPais());
            paisesDTO.setNomePais(paisesDB.getNomePais());
            paisesDTO.setCodigoPais(paisesDB.getCodigoPais());
            return paisesDTO;
        }catch (NoSuchElementException e ) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-06", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }
    }

    public PaisesDTO findByName(String nome) {

        try {
            var paisesDB = paisesRepository.findByNomePais(nome).get();

            PaisesDTO paisesDTO = new PaisesDTO();
            paisesDTO.setIdPais(paisesDB.getIdPais());
            paisesDTO.setNomePais(paisesDB.getNomePais());
            paisesDTO.setCodigoPais(paisesDB.getCodigoPais());
            return paisesDTO;
        }catch (NoSuchElementException e ) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-06", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }

    }
    public PaisesDTO findByCodigo(Integer codigo) {

        try {
            var paisesDB = paisesRepository.findByCodigoPais(codigo).get();

            PaisesDTO paisesDTO = new PaisesDTO();
            paisesDTO.setIdPais(paisesDB.getIdPais());
            paisesDTO.setNomePais(paisesDB.getNomePais());
            paisesDTO.setCodigoPais(paisesDB.getCodigoPais());
            return paisesDTO;
        }catch (NoSuchElementException e ) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-06", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }
    }

    public PaisesDTO insert(Paises paises) throws  Exception{

        try {
            Optional<PaisesDB> paisesCondicional = paisesRepository.findByCodigoPais(paises.getCodigoPais());
            if(paisesCondicional.isPresent()) {
                throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-07");
            }
            var paisesMapper = mapToDB(paises);
            var paisesDB = paisesRepository.save(paisesMapper);

            return mapToDTO(paisesDB);
        }catch (Exception e) {
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }
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

    public Paises update(Integer id, Paises paises) {

        PaisesDB paisesDB = paisesRepository.findById(id).get();
        updateData(paises, paisesDB);
        paisesRepository.save(paisesDB);
        return paises;
    }
    private void updateData(Paises paises, PaisesDB paisesDB) {
        paisesDB.setIdPais(paises.getIdPais());
        paisesDB.setNomePais(paises.getNomePais());
        paisesDB.setCodigoPais(paises.getCodigoPais());
    }
}




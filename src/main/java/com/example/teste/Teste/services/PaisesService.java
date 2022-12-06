package com.example.teste.Teste.services;



import com.example.teste.Teste.DTO.PaisesDTO;
import com.example.teste.Teste.database.PaisesDB;
import com.example.teste.Teste.entity.Paises;
import com.example.teste.Teste.exceptions.ExceptionApiOrdem;
import com.example.teste.Teste.repositories.PaisesRepository;
import com.example.teste.Teste.services.interfaces.InterfacePaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaisesService implements InterfacePaisesService {


    @Autowired
    private PaisesRepository paisesRepository;

    @Override
    public List<PaisesDB> listAll() {
        List<PaisesDB> listaDePaises = paisesRepository.findAll();
        return  listaDePaises;
    }

    @Override
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

    @Override
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
    @Override
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

    @Override
    public PaisesDTO insert(Paises paises) throws  Exception {

        try {
            Optional<PaisesDB> paisesByCodigo = paisesRepository.findByCodigoPais(paises.getCodigoPais());
            Optional<PaisesDB> paisesByName   = paisesRepository.findByNomePais(paises.getNomePais());
            if(paisesByCodigo.isPresent() || paisesByName.isPresent()) {
                throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-07");
            }
            var paisesMapper = mapToDB(paises);
            var paisesDB = paisesRepository.save(paisesMapper);

            return mapToDTO(paisesDB);
        }catch (ExceptionApiOrdem e) {
            throw e;
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

    @Override
    public void delete(Integer id) {
        try{
            paisesRepository.deleteById(id);
        }catch (NoSuchElementException e) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-06", e.getMessage());
        }catch (Exception e){
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }

    }

    @Override
    public Paises update(Integer id, Paises paises) {
        try {
            PaisesDB paisesDB = paisesRepository.findById(id).get();
            updateData(paises, paisesDB);
            paisesRepository.save(paisesDB);
            return paises;
        }catch (NoSuchElementException e) {
            throw new ExceptionApiOrdem(HttpStatus.BAD_REQUEST, "CAD-06", e.getMessage());
        }catch (Exception e){
            throw new ExceptionApiOrdem(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-10", e.getMessage());
        }

    }
    private void updateData(Paises paises, PaisesDB paisesDB) {
        paisesDB.setIdPais(paises.getIdPais());
        paisesDB.setNomePais(paises.getNomePais());
        paisesDB.setCodigoPais(paises.getCodigoPais());
    }
}




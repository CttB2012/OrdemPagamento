package com.example.teste.Teste.services.interfaces;

import com.example.teste.Teste.DTO.PaisesDTO;
import com.example.teste.Teste.database.PaisesDB;
import com.example.teste.Teste.entity.Paises;

import java.util.List;

public interface InterfacePaisesService {

    List<PaisesDB> listAll();

    PaisesDTO findById(Integer id);

    PaisesDTO findByName(String nome);

    PaisesDTO findByCodigo(Integer codigo);

    PaisesDTO insert(Paises paises) throws Exception;

    void delete(Integer id);

    Paises update(Integer id, Paises paises);

}

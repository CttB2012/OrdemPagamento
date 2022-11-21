package com.example.teste.Teste.repositories;

import com.example.teste.Teste.database.PaisesDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisesRepository  extends JpaRepository<PaisesDB, Integer> {

    Optional<PaisesDB> findByName(String nomePais);


    Optional<PaisesDB> findByCodigo(Integer codigoPais);

}

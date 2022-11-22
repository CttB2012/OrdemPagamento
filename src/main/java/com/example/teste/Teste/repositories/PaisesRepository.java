package com.example.teste.Teste.repositories;

import com.example.teste.Teste.database.PaisesDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisesRepository  extends JpaRepository<PaisesDB, Integer> {

    Optional<PaisesDB> findByNomePais(String nomePais);


    Optional<PaisesDB> findByCodigoPais(Integer codigoPais);

}

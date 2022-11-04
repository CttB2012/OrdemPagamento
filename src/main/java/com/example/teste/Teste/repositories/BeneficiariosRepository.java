package com.example.teste.Teste.repositories;

import com.example.teste.Teste.database.BeneficiariosDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiariosRepository extends JpaRepository<BeneficiariosDB, Long> {
}

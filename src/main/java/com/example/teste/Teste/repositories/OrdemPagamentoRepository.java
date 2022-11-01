package com.example.teste.Teste.repositories;


import com.example.teste.Teste.database.OrdemPagamentoDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemPagamentoRepository extends JpaRepository<OrdemPagamentoDB, Long> {
}

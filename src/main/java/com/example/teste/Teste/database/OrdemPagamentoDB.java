package com.example.teste.Teste.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrdemPagamentoDB {

    @Id
    @Column(name = "idDocumentoBeneficiario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumentoBeneficiario;

    @Column(name = "CodigoMoeda" )
    private Integer codigoMoeda;

    @Column(name = "SimboloMoeda")
    private String simboloMoeda;

    @Column(name = "ValorMoedaEstrangeira")
    private BigDecimal valorMoedaEstrangeira;

    @Column(name = "NomeBeneficiario")
    private String nomeBeneficiario;

    @Column(name = "OrdemPrincipalApp")
    private Long numeroOrdemPagamento;


}

package com.example.teste.Teste.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrdemPagamento")
public class OrdemPagamentoDB {

    @Id
    @Column(name = "idBeneficiario")
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

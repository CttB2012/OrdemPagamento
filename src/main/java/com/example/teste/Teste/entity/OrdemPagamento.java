package com.example.teste.Teste.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdemPagamento {

    @JsonProperty("OrdemPrincipalApp")
    private Long numeroOrdemPagamento;

    @JsonProperty("CodigoMoeda")
    private Integer codigoMoeda;

    @JsonProperty("SimboloMoeda")
    private String simboloMoeda;

    @JsonProperty("ValorMoeda")
    private BigDecimal valorMoedaEstrangeira;

    @JsonProperty("Beneficiarios")
    private String nomeBeneficiario;

}
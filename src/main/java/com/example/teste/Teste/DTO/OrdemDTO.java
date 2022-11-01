package com.example.teste.Teste.DTO;



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
public class OrdemDTO {

    @JsonProperty("idDocumento")
    private Long idDocumentoBeneficiario;

    @JsonProperty("CodigoMoeda")
    private Integer codigoMoeda;

    @JsonProperty("SimboloMoeda")
    private String simboloMoeda;

    @JsonProperty("ValorMoeda")
    private BigDecimal valorMoedaEstrangeira;

    @JsonProperty("Beneficiario")
    private String nomeBeneficiario;

    @JsonProperty("OrdemPrincipalApp")
    private Long numeroOrdemPagamento;

}
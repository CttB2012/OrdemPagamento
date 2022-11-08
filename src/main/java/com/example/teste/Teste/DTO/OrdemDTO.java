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

    @JsonProperty("idBeneficiario")
    private Long idDocumentoBeneficiario;

    @JsonProperty("nomeBeneficiario")
    private String nomeBeneficiario;

    @JsonProperty("CodigoMoeda")
    private Integer codigoMoeda;

    @JsonProperty("SimboloMoeda")
    private String simboloMoeda;

    @JsonProperty("ValorMoeda")
    private BigDecimal valorMoedaEstrangeira;

    @JsonProperty("OrdemPrincipalApp")
    private Long numeroOrdemPagamento;

}
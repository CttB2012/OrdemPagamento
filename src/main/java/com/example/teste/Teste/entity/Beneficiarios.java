package com.example.teste.Teste.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Beneficiarios {

    @JsonProperty("idBeneficiario")
    private Long idBeneficiario;

    @JsonProperty("nomeBeneficiario")
    private String nomeBeneficiario;

    @JsonProperty("idDocumento")
    private Long idDocumentoBeneficiario;

}

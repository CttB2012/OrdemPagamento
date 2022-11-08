package com.example.teste.Teste.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiariosDTO {


    @JsonProperty("idBeneficiario")
    private Long idBeneficiario;

    @JsonProperty("idDocumento")
    private Long idDocumentoBeneficiario;

    @JsonProperty("nomeBeneficiario")
    private String nomeBeneficiario;


}

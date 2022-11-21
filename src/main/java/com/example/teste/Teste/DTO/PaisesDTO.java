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
public class PaisesDTO {

    @JsonProperty("idPais")
    private Integer idPais;

    @JsonProperty("nomePais")
    private String nomePais;

    @JsonProperty("codigoPais")
    private Integer codigoPais;

}

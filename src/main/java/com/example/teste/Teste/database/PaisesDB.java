package com.example.teste.Teste.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaisesDB {


    @JsonProperty("idPais")
    private Integer idPais;

    @JsonProperty("nomePais")
    private String nomePais;

    @JsonProperty("codigoPais")
    private Integer codigoPais;

}

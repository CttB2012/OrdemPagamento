package com.example.teste.Teste.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paises {


    @JsonProperty("idPais")
    private Integer idPais;

    @NotBlank(message = "O nome do pais deve ser informado")
    @Pattern(regexp = "[A-Za-z ÇçÁáÉéÍíÓóÚúÃãÂâÊêÎîÔôÛû\\s]+", message = "O nome do país não pode conter números ou caracteres especiais")
    @JsonProperty("nomePais")
    private String nomePais;

    @Min(value = 100)
    @Max(value = 9999)
    @JsonProperty("codigoPais")
    private Integer codigoPais;

}

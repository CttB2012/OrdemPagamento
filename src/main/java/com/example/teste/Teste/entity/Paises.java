package com.example.teste.Teste.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paises {


    @JsonProperty("idPais")
    private Integer idPais;

    @NotBlank(message = "O nome do pais deve ser informado")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "O nome não pode ter caracteres especiais")
    @JsonProperty("nomePais")
    private String nomePais;

    @NotBlank(message = "O código do Pais deve ser informado")
    @Size(max = 4, min = 6, message = "Quantidade de dígitos incorreta")
    @Pattern(regexp = "[0-9 \\s]+", message = "CPF inválido")
    @JsonProperty("codigoPais")
    private Integer codigoPais;

}

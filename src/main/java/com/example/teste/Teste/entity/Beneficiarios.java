package com.example.teste.Teste.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Beneficiarios {


    @JsonProperty("idBeneficiario")
    private Long idBeneficiario;

    @NotNull(message= "Nome é obrigatorio" )
    @NotBlank(message = "O nome deve ser informado")
    @NotEmpty(message = "O nome não pode ser vazio")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "O nome não pode ter caracteres especiais")
    @JsonProperty("nomeBeneficiario")
    private String nomeBeneficiario;

    @NotNull(message = "O número do CPF deve ser informado")
    @JsonProperty("idDocumento")
    private String idDocumentoBeneficiario;

}

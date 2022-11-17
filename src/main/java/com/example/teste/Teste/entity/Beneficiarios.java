package com.example.teste.Teste.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Beneficiarios {


    @JsonProperty("idBeneficiario")
    private Long idBeneficiario;

    @NotBlank(message = "O nome deve ser informado")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "O nome não pode ter caracteres especiais")
    @JsonProperty("nomeBeneficiario")
    private String nomeBeneficiario;

    @NotBlank(message = "O número do CPF deve ser informado")
    @Size(max = 11, min = 11, message = "Quantidade de dígitos incorreta")
    @Pattern(regexp = "[0-9 X\\s]+", message = "CPF inválido")
    @JsonProperty("idDocumento")
    private String idDocumentoBeneficiario;

}

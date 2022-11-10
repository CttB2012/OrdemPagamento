package com.example.teste.Teste.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdemPagamento {

    @JsonProperty("OrdemPrincipalApp")
    private Long numeroOrdemPagamento;

    @NotNull(message = "O código da moeda deve ser informado")
    @JsonProperty("CodigoMoeda")
    private Integer codigoMoeda;

    @NotNull(message = "O símbolo da moeda deve ser informado")
    @NotBlank(message = "O símbolo da moeda deve ser informado")
    @NotEmpty(message = "O símbolo não pode ser vazio")
    @JsonProperty("SimboloMoeda")
    private String simboloMoeda;

    @JsonProperty("ValorMoeda")
    private BigDecimal valorMoedaEstrangeira;

    @NotNull(message= "Nome é obrigatorio" )
    @NotBlank(message = "O nome deve ser informado")
    @NotEmpty(message = "O nome não pode ser vazio")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "O nome não pode ter caracteres especiais")
    @JsonProperty("nomeBeneficiario")
    private String nomeBeneficiario;

}
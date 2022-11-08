package com.example.teste.Teste.database;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BeneficiariosDB {

    @Id
    @Column(name = "idBeneficiario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBeneficiario;

    @Column(name = "nomeBeneficiario")
    private String nomeBeneficiario;

    @Column(name = "idDocumento")
    private Long idDocumentoBeneficiario;



}

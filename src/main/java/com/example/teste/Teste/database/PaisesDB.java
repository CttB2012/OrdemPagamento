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
public class PaisesDB {


    @Id
    @Column(name = "idPais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;

    @Column(name = "nomePais")
    private String nomePais;

    @Column(name = "codigoPais")
    private Integer codigoPais;

}

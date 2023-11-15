package br.com.fiap.global.backend.model;

import jakarta.persistence.*;

@Entity(name = "objetivo")
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String global;

    @Column
    private String brasil;

}

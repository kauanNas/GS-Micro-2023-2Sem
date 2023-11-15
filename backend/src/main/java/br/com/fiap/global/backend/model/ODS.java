package br.com.fiap.global.backend.model;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity(name = "ods")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"codigo"} )})
public class ODS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @ManyToOne
    @JoinColumn
    private Objetivo objetivo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ods")
    private List<Indicador> indicadores;

}

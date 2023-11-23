package br.com.fiap.global.backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ods")
public class ODS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_objetivo")
    private Objetivo objetivo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ods")
    private List<Indicador> indicadores;

}

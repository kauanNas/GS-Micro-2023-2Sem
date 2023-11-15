package br.com.fiap.global.backend.model;

import jakarta.persistence.*;

@Entity(name = "indicador")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"codigo"} )})
public class Indicador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @Column
    private String descricao;

    @Column
    private Integer ano;

    @Column
    private Double consumo;

    @ManyToOne
    @JoinColumn(name = "id_ods")
    private ODS ods;

}

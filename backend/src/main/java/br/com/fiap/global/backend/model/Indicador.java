package br.com.fiap.global.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;



@Getter
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
    private String ano;

    @Column
    private Double consumo;

    @Column
    private String regiao;

    @ManyToOne
    @JoinColumn(name = "id_ods")
    @JsonIgnore
    private ODS ods;

}

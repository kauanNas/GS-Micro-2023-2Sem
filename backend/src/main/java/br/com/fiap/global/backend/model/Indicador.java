package br.com.fiap.global.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity(name = "indicador")
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

    public Indicador(Long id, String codigo, String descricao, String ano, Double consumo, String regiao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ano = ano;
        this.consumo = consumo;
        this.regiao = regiao;
    }
}

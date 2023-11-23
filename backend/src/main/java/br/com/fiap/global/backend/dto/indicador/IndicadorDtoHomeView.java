package br.com.fiap.global.backend.dto.indicador;

public record IndicadorDtoHomeView(String codigo) implements Comparable<IndicadorDtoHomeView>{


    @Override
    public int compareTo(IndicadorDtoHomeView o) {
        return this.codigo.compareTo(o.codigo);
    }
}

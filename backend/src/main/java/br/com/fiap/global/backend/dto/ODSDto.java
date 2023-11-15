package br.com.fiap.global.backend.dto;

import java.util.List;

public record ODSDto(String id, ObjetivoDto objetivos, List<IndicadorDtoODS> indicadores) {



}

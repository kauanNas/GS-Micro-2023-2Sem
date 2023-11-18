package br.com.fiap.global.backend.dto.ods;

import br.com.fiap.global.backend.dto.indicador.IndicadorDtoODS;
import br.com.fiap.global.backend.dto.objetivo.ObjetivoDto;

import java.util.List;

public record ODSDto(String id, ObjetivoDto objetivos, List<IndicadorDtoODS> indicadores) {



}

package br.com.fiap.global.backend.service;

import br.com.fiap.global.backend.dto.indicador.IndicadorDtoHomeView;
import br.com.fiap.global.backend.dto.indicador.IndicadorDtoMetricasView;
import br.com.fiap.global.backend.model.Indicador;
import br.com.fiap.global.backend.dto.indicador.IndicadorDto;
import br.com.fiap.global.backend.repository.IndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class IndicadorService {

    @Autowired
    private IndicadorRepository repository;

    public IndicadorDto buscaIndicador(Long id) {
        Indicador indicador = repository.getReferenceById(id);
        return new IndicadorDto(indicador.getAno(), indicador.getConsumo());
    }

    public List<IndicadorDtoHomeView> buscaListaIndicadores() {
        List<Indicador> indicadoresNaoTratados = repository.findAll();
        List<IndicadorDtoHomeView> indicadoresDtoHomeView = new ArrayList<>();
        for(Indicador indicador : indicadoresNaoTratados){
            IndicadorDtoHomeView dtoHomeView = new IndicadorDtoHomeView(indicador.getCodigo());
            indicadoresDtoHomeView.add(dtoHomeView);
        }

        HashSet<IndicadorDtoHomeView> indicadoresTratados = new HashSet<>(indicadoresDtoHomeView);

        List<IndicadorDtoHomeView> indicadoresFinais = new ArrayList<>(indicadoresTratados);

        Collections.sort(indicadoresFinais);

        return indicadoresFinais;
    }

    public List<IndicadorDtoMetricasView> buscaMetricas(String id) {
        List<Indicador> indicadores = repository.findAllByCodigo(id);
        List<IndicadorDtoMetricasView> indicadoresDtoMetricasView = new ArrayList<>();
        for (Indicador indicador : indicadores){
            IndicadorDtoMetricasView dtoMetricasView = new IndicadorDtoMetricasView(id, indicador.getAno(), indicador.getConsumo(), indicador.getDescricao(), indicador.getRegiao());
            indicadoresDtoMetricasView.add(dtoMetricasView);
        }

        return indicadoresDtoMetricasView;
    }
}

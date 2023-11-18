package br.com.fiap.global.backend.service;

import br.com.fiap.global.backend.model.Indicador;
import br.com.fiap.global.backend.dto.IndicadorDto;
import br.com.fiap.global.backend.repository.IndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicadorService {

    @Autowired
    private IndicadorRepository repository;

    public IndicadorDto buscaIndicador(Long id) {
        Indicador indicador = repository.getReferenceById(id);
        return new IndicadorDto(indicador.getAno(), indicador.getConsumo());
    }

    public List<Indicador> buscaListaIndicadores() {
        return repository.findAll();
    }
}

package br.com.fiap.global.backend.service;

import br.com.fiap.global.backend.dto.IndicadoDto;
import br.com.fiap.global.backend.dto.ODSDto;
import br.com.fiap.global.backend.dto.ObjetivoDto;
import br.com.fiap.global.backend.model.Indicador;
import br.com.fiap.global.backend.model.ODS;
import br.com.fiap.global.backend.repository.ODSRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ODSService {

    @Autowired
    private ODSRepository repository;

    @Transactional
    public ODSDto buscaListaObjetivos() {
        List<ODS> listaODS = repository.findAll();
        String id = null;
        ObjetivoDto objetivoDto = null;
        List<IndicadoDto> indicadores = new ArrayList<>();

        for(ODS ods : listaODS){
            id = ods.getCodigo();
            objetivoDto = new ObjetivoDto(ods.getObjetivo().getGlobal(), ods.getObjetivo().getBrasil());
            for(Indicador obj : ods.getIndicadores()){
                IndicadoDto indicador = new IndicadoDto(obj.getCodigo(), obj.getDescricao());
                indicadores.add(indicador);
            }
        }

        return new ODSDto(id, objetivoDto, indicadores);
    }

}

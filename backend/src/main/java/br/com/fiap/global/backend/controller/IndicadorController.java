package br.com.fiap.global.backend.controller;

import br.com.fiap.global.backend.dto.indicador.IndicadorDto;
import br.com.fiap.global.backend.dto.indicador.IndicadorDtoHomeView;
import br.com.fiap.global.backend.dto.indicador.IndicadorDtoMetricasView;
import br.com.fiap.global.backend.model.Indicador;
import br.com.fiap.global.backend.service.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndicadorController {

    @Autowired
    private IndicadorService indicadorService;

    @RequestMapping(value = "/indicador/{id}", method = RequestMethod.GET)
    public IndicadorDto indicador(@PathVariable Long id){
        return indicadorService.buscaIndicador(id);
    }

    @RequestMapping(value = "/indicadores", method = RequestMethod.GET)
    public List<IndicadorDtoHomeView> listaIndicadores(){
        return indicadorService.buscaListaIndicadores();
    }

    @RequestMapping(value = "/buscaMetricas/{id}")
    public List<IndicadorDtoMetricasView> metricasIndicador(@PathVariable String id){
        return indicadorService.buscaMetricas(id);
    }
}
